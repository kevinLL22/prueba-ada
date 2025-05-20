package com.kevinll.company_service.service;


import com.kevinll.company_service.repository.inter.DuplicateIdProjection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.kevinll.company_service.repository.entity.Company;
import com.kevinll.company_service.repository.inter.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository repository;

    // CREATE
    public Company create(Company company) {
        return repository.save(company);
    }

    // READ
    public List<Company> findAll() {
        return repository.findAll();
    }

    public Company findById(Long id) {
        log.info("ente here");
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found: " + id));
    }

    List<DuplicateIdProjection> findDuplicateIds(){
        return repository.findDuplicateIds();
    }

    // UPDATE
    public Company update(Long id, Company newData) {
        Company company = findById(id);
        company.setCodigo(newData.getCodigo());
        company.setNombre(newData.getNombre());
        company.setDescripcion(newData.getDescripcion());
        return repository.save(company);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

