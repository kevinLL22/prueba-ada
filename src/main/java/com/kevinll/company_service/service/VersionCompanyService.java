package com.kevinll.company_service.service;

import com.kevinll.company_service.repository.entity.Company;
import com.kevinll.company_service.repository.entity.Version;
import com.kevinll.company_service.repository.entity.VersionCompany;
import com.kevinll.company_service.repository.inter.CompanyRepository;
import com.kevinll.company_service.repository.inter.VersionCompanyRepository;
import com.kevinll.company_service.repository.inter.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VersionCompanyService {

    private final VersionCompanyRepository vcRepo;
    private final CompanyRepository companyRepo;
    private final VersionRepository versionRepo;

    /* ------------ CREATE ------------ */
    public VersionCompany create(Long companyId, Long versionId, String description) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found: " + companyId));

        Version version = versionRepo.findById(versionId)
                .orElseThrow(() -> new IllegalArgumentException("Version not found: " + versionId));

        VersionCompany vc = VersionCompany.builder()
                .company(company)
                .version(version)
                .description(description)
                .build();

        return vcRepo.save(vc);
    }

    public VersionCompany create(VersionCompany vc) {
        return vcRepo.save(vc);
    }

    /* ------------ READ ------------ */
    public VersionCompany findById(Long id) {
        return vcRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("VersionCompany not found: " + id));
    }

    public List<VersionCompany> findByCompany(Long companyId) {
        return vcRepo.findByCompany_Id(companyId);
    }

    public List<VersionCompany> findByVersion(Long versionId) {
        return vcRepo.findByVersion_Id(versionId);
    }

    /* ------------ UPDATE ------------ */
    public VersionCompany updateDescription(Long id, String newDescription) {
        VersionCompany vc = findById(id);
        vc.setDescription(newDescription);
        return vcRepo.save(vc);
    }

    /* ------------ DELETE ------------ */
    public void delete(Long id) {
        vcRepo.deleteById(id);
    }
}

