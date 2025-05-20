package com.kevinll.company_service.service;

import com.kevinll.company_service.repository.entity.Application;
import com.kevinll.company_service.repository.inter.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository repository;

    /* ----------------- CRUD ----------------- */

    // CREATE
    public Application create(Application app) {
        return repository.save(app);
    }

    // READ (todos)
    public List<Application> findAll() {
        return repository.findAll();
    }

    // READ (uno)
    public Application findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Application not found: " + id));
    }

    // UPDATE
    public Application update(Long id, Application data) {
        Application app = findById(id);
        app.setCode(data.getCode());
        app.setName(data.getName());
        app.setDescription(data.getDescription());
        return repository.save(app);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

