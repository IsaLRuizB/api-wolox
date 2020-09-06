package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.User;
import com.prueba.api.wolox.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User entity) {
        try {
            return  userRepository.save(entity);
        } catch (DataAccessException dae) {
            System.err.println(dae);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (DataAccessException dae) {
            System.err.println(dae);
        }
    }

    @Override
    public boolean existsById(Long id) {
       if (this.findById(id).isPresent())
           return true;


        return false;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> objects) {
        return null;
    }
}
