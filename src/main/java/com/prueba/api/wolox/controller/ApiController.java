package com.prueba.api.wolox.controller;

import com.prueba.api.wolox.dto.Comments;
import com.prueba.api.wolox.models.entity.Permiso;
import com.prueba.api.wolox.models.entity.User;
import com.prueba.api.wolox.services.PermisoService;
import com.prueba.api.wolox.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ApiController {

    @Autowired
    PermisoService permisoService;

    @Autowired
    UserService userService;

    @PostMapping("/Api/compartir/album")
    public ResponseEntity<?> registrarAlbumCompartido(@Valid @RequestBody Permiso entity, BindingResult result){

        if(result.hasErrors()) {
            return this.validar(result);
        }
        if (!entity.getIdUserComp().equals(entity.getIdUser())) {
            if (!permisoService.findByIdUserCompAndIdUserAndIdAlbum(entity.getIdUserComp(), entity.getIdUser(), entity.getIdAlbum()).isPresent()) {
                Permiso entityDB = permisoService.save(entity);
                return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
            }else{
                return new ResponseEntity<>("Este usuario ya posee permisos en este album ", HttpStatus.NOT_FOUND);
            }
        }
           return new ResponseEntity<>("El usuario compartido no puede ser el mismo dueño ", HttpStatus.NOT_FOUND);
    }


    @PutMapping("/Api/cambiar/album")
    public ResponseEntity<?> cambiarPermisosPorAlbum(@Valid @RequestBody Permiso permiso, BindingResult result){

        if(result.hasErrors()) {
            return this.validar(result);
        }
        Optional<Permiso> optional =permisoService.findByIdUserCompAndIdUserAndIdAlbum(permiso.getIdUserComp(),permiso.getIdUser(), permiso.getIdAlbum());
        if (optional==null){
            return new ResponseEntity<>("Este usuario no tiene permisos asignados a este album", HttpStatus.NOT_FOUND);
        }
        Permiso entityDB= optional.get();
        entityDB.setIdAlbum(permiso.getIdAlbum());
        entityDB.setIdUser(permiso.getIdUser());
        entityDB.setIdUserComp(permiso.getIdUserComp());
        entityDB.setTipoPermiso(permiso.getTipoPermiso());
        return ResponseEntity.status(HttpStatus.CREATED).body(permisoService.save(entityDB));
    }
    @GetMapping("/Api/consultar/{idAlbum}/{tipoPermiso}")
    public ResponseEntity<?> consultarUsuariosPermisoPorAlbum(@PathVariable Long idAlbum, @PathVariable char tipoPermiso ){
        List<Long> listIdUserComp =permisoService.findByIdAlbumAndPermiso(idAlbum,tipoPermiso);

        if (listIdUserComp.isEmpty()){
            return new ResponseEntity<>("No se encontro informacion", HttpStatus.NOT_FOUND);

        }
        List<User> usuarios= (List<User>) userService.findAll();
        List<String> listResult = usuarios
                .stream()
                .filter(user -> listIdUserComp
                        .stream()
                        .anyMatch(idUserComp -> user.getId().equals(idUserComp))
                )
                .map(user -> user.getName())
                .collect(Collectors.toList());
        return ResponseEntity.ok(listResult);

    }

    public ResponseEntity<?> validar(BindingResult result){
        Map<String,Object> errores=  new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errores.put(err.getField(), "El campo "+ err.getField() +" "+err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }


}
