package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Album;
import com.prueba.api.wolox.models.entity.Permiso;

import java.util.Optional;

public interface AlbumService {

    public Iterable<Album> findAll();

    public Optional<Album> findById(Long id);

    public Album save(Album entity);

    public void deleteById (Long id);
}
