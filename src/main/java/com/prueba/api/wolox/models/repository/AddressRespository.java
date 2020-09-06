package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRespository extends CrudRepository<Address,Long> {
}
