package com.kevinll.company_service.service;

import com.kevinll.company_service.repository.entity.*;
import com.kevinll.company_service.repository.inter.CursorRepository;
import com.kevinll.company_service.repository.inter.DuplicateIdProjection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CursorService {

    private final CursorRepository repository;
    private final CompanyService companyService;
    private final ApplicationService applicationService;
    private final VersionService versionService;
    private final VersionCompanyService versionCompanyService;


    public TmpC findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("temporal not found not found: " + id));
    }

    public TmpC findAll() {
        return repository.findAll().getFirst();
    }

    public void mapIntoTables(TmpC tmpC) {

        log.info("show temp {}", tmpC);


        //add company
        Company company = new Company((long) tmpC.getCompanyId(), tmpC.getCodigoCompany(), tmpC.getNameCompany(), tmpC.getDescriptionCompany());

        companyService.create(company);

        // add application
        Application application = new Application((long) tmpC.getAppId(), tmpC.getAppCode(), tmpC.getAppName(), tmpC.getAppDescription());
        applicationService.create(application);

        //add version
        Version version = new Version((long) tmpC.getVersionId(), application, tmpC.getVersion(), tmpC.getVersionDescription());
        versionService.create(version);

        //version company

        VersionCompany versionCompany = new VersionCompany((long)tmpC.getVersionCompanyId(), company, version, tmpC.getVersionCompanyDescription());
        versionCompanyService.create(versionCompany);


    }

    public String mappingByCall(int idCompany){
        //TmpC currentTempData = findById(idCompany);
        TmpC all = findAll();
        mapIntoTables(all);

        return "success operation";
    }

    public void deleteCopyData(){

        List<DuplicateIdProjection> duplicateIds = companyService.findDuplicateIds();

    }

}
