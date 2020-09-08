package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Album;
import com.prueba.api.wolox.models.entity.Company;

import java.util.Optional;

public interface CompanyService {
    public Iterable<Company> findAll();

    public Optional<Company> findById(Long id);

    public Company save(Company entity);

    public void deleteById (Long id);
}
