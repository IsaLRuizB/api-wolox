package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
