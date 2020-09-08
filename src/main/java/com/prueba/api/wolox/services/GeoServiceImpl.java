package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Geo;
import com.prueba.api.wolox.models.repository.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeoServiceImpl implements GeoService {

    @Autowired
    GeoRepository geoRepository;

    @Override
    public Iterable<Geo> findAll() {
        return geoRepository.findAll();
    }

    @Override
    public Optional<Geo> findById(Long id) {
        return geoRepository.findById(id);
    }

    @Override
    public Geo save(Geo entity) {
        try {
            return  geoRepository.save(entity);
        } catch (DataAccessException dae) {
            System.err.println(dae);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        geoRepository.deleteById(id);

    }
}
