package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.User;

import java.util.Optional;

public interface UserService{

    public Iterable<User> findAll();

    public Optional<User> findById(Long id);

    public User save(User entity);

    public void deleteById (Long id);

   public boolean existsById(Long id);

    public Iterable<User> saveAll(Iterable<User> objects);

}
