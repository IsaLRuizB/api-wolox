package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Album;
import com.prueba.api.wolox.models.entity.Geo;

import java.util.Optional;

public interface GeoService {

    public Iterable<Geo> findAll();

    public Optional<Geo> findById(Long id);

    public Geo save(Geo entity);

    public void deleteById (Long id);
}
