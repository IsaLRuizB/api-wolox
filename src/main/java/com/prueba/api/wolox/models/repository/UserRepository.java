package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
}