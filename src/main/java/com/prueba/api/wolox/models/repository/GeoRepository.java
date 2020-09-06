package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Geo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends CrudRepository<Geo,Long> {
}
