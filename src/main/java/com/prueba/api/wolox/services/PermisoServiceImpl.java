package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Permiso;
import com.prueba.api.wolox.models.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoServiceImpl implements PermisoService{

    @Autowired
    PermisoRepository permisoRepository;

    @Override
    public Iterable<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    @Override
    public Optional<Permiso> findById(Long id) {
        return permisoRepository.findById(id);
    }

    @Override
    public Permiso save(Permiso entity) {
        try {
            return  permisoRepository.save(entity);
        } catch (DataAccessException dae) {
            System.err.println(dae);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        permisoRepository.deleteById(id);
    }

    @Override
    public Optional<Permiso> findByIdUserCompAndIdUserAndIdAlbum(Long idUserCpomp, Long idUser, Long idAlbum) {
        return permisoRepository.findByIdUserCompAndIdUserAndIdAlbum(idUserCpomp, idUser, idAlbum);
    }

    @Override
    public List<Long> findByIdAlbumAndPermiso(Long idAlbum, char tipoPermiso) {
        return permisoRepository.findByIdAlbumAndPermiso(idAlbum,tipoPermiso);
    }
}
