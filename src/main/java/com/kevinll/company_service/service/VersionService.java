package com.kevinll.company_service.service;


import com.kevinll.company_service.repository.entity.Application;
import com.kevinll.company_service.repository.entity.Version;
import com.kevinll.company_service.repository.inter.ApplicationRepository;
import com.kevinll.company_service.repository.inter.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VersionService {

    private final VersionRepository versionRepo;
    private final ApplicationRepository appRepo;

    /* ---------- CREATE ---------- */
    public Version create(Long appId, Version data) {
        Application app = appRepo.findById(appId)
                .orElseThrow(() -> new IllegalArgumentException("Application not found: " + appId));
        data.setApplication(app);
        return versionRepo.save(data);
    }
    public Version create(Version data) {
        return versionRepo.save(data);
    }

    /* ---------- READ ---------- */
    public Version findById(Long id) {
        return versionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Version not found: " + id));
    }

    public List<Version> findByApplication(Long appId) {
        return versionRepo.findByApplication_Id(appId);
    }

    /* ---------- UPDATE ---------- */
    public Version update(Long id, Version newData) {
        Version ver = findById(id);
        ver.setVersion(newData.getVersion());
        ver.setDescription(newData.getDescription());
        return versionRepo.save(ver);
    }

    /* ---------- DELETE ---------- */
    public void delete(Long id) {
        versionRepo.deleteById(id);
    }
}

