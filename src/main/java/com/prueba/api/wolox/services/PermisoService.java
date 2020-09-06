package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Permiso;
import com.prueba.api.wolox.models.entity.User;

import java.util.Optional;

public interface PermisoService {

    public Iterable<Permiso> findAll();

    public Optional<Permiso> findById(Long id);

    public Permiso save(Permiso entity);

    public void deleteById (Long id);

    public Optional<Permiso> findByIdUserCompAndIdUserAndIdAlbum(Long idUserCpomp, Long idUser, Long idAlbum);
}
