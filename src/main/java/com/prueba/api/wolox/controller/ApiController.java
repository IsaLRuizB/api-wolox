package com.prueba.api.wolox.controller;

import com.prueba.api.wolox.models.entity.Permiso;
import com.prueba.api.wolox.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    PermisoService permisoService;


    @PostMapping("/compartir/album")
    public ResponseEntity<?> registrarAlbumCompartido(@Valid @RequestBody Permiso entity, BindingResult result){

        if(result.hasErrors()) {
            return this.validar(result);
        }
       if (!permisoService.findByIdUserCompAndIdUserAndIdAlbum(entity.getIdUserComp(),entity.getIdUser(), entity.getIdAlbum()).isPresent()){
           Permiso entityDB = permisoService.save(entity);
           return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
       }

           return new ResponseEntity<>("Este usuario ya posee permisos en este album ", HttpStatus.NOT_FOUND);
    }


    @PutMapping("/cambiar/album")
    public ResponseEntity<?> cambiarPermisosPorAlbum(@Valid @RequestBody Permiso permiso, BindingResult result){

        if(result.hasErrors()) {
            return this.validar(result);
        }
        Optional<Permiso> optional =permisoService.findByIdUserCompAndIdUserAndIdAlbum(permiso.getIdUserComp(),permiso.getIdUser(), permiso.getIdAlbum());
        if (optional==null){
            Permiso entityDB= optional.get();
            entityDB.setIdAlbum(permiso.getIdAlbum());
            entityDB.setIdUser(permiso.getIdUser());
            entityDB.setIdUserComp(permiso.getIdUserComp());
            entityDB.setTipoPermiso(permiso.getTipoPermiso());
            return ResponseEntity.status(HttpStatus.CREATED).body(permisoService.save(entityDB));
                   }
        return new ResponseEntity<>("Este usuario ya posee este permiso ", HttpStatus.NOT_FOUND);

    }


    public ResponseEntity<?> validar(BindingResult result){
        Map<String,Object> errores=  new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errores.put(err.getField(), "El campo "+ err.getField() +" "+err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }


}
