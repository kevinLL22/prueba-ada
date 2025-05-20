package com.kevinll.company_service.repository.inter;


import com.kevinll.company_service.repository.entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version, Long> {

    /** Todas las versiones de una misma aplicación */
    List<Version> findByApplication_Id(Long appId);


}

