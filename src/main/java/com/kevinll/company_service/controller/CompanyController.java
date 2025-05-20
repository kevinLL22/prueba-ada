package com.kevinll.company_service.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kevinll.company_service.repository.entity.Company;
import com.kevinll.company_service.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    // GET /api/companies
    @GetMapping
    public List<Company> list() {
        return service.findAll();
    }

    // GET /api/companies/{id}
    @GetMapping("/{id}")
    public Company get(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /api/companies
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return service.create(company);
    }

    // PUT /api/companies/{id}
    @PutMapping("/{id}")
    public Company update(@PathVariable Long id, @RequestBody Company company) {
        return service.update(id, company);
    }

    // DELETE /api/companies/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
