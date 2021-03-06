package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
}
