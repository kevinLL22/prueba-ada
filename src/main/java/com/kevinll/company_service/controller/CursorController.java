package com.kevinll.company_service.controller;

import com.kevinll.company_service.repository.entity.Company;
import com.kevinll.company_service.service.CompanyService;
import com.kevinll.company_service.service.CursorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursor")
@RequiredArgsConstructor
public class CursorController {

    private final CursorService service;

    @GetMapping("/{id}")
    public String get(@PathVariable int id) {
        return service.mappingByCall(id);
    }

}
