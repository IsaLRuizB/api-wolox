package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album,Long> {
}
