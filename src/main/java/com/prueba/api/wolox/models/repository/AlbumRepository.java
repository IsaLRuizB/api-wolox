package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}
