package com.prueba.api.wolox.services;

import com.prueba.api.wolox.models.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl  implements CompanyService{

    @Autowired
    CompanyService companyService;
    @Override
    public Iterable<Company> findAll() {
        return companyService.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyService.findById(id);
    }

    @Override
    public Company save(Company entity) {
        try {
            return  companyService.save(entity);
        } catch (DataAccessException dae) {
            System.err.println(dae);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        companyService.deleteById(id);
    }
}
