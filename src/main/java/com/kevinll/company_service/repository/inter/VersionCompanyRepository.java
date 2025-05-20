package com.kevinll.company_service.repository.inter;


import com.kevinll.company_service.repository.entity.VersionCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionCompanyRepository extends JpaRepository<VersionCompany, Long> {

    /* Versiones por empresa */
    List<VersionCompany> findByCompany_Id(Long companyId);

    /* Versiones por versión “base” */
    List<VersionCompany> findByVersion_Id(Long versionId);

    /* Buscar uno por empresa + versión */
    VersionCompany findByCompany_IdAndVersion_Id(Long companyId, Long versionId);
}

