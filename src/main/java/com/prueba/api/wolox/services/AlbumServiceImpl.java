package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Album;
import com.prueba.api.wolox.models.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    AlbumRepository albumRepository;
    @Override
    public Iterable<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public Album save(Album entity) {
        try {
            return  albumRepository.save(entity);
        } catch (DataAccessException dae) {
            System.err.println(dae);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {

    }
}
