package com.kevinll.company_service.repository.inter;

import com.kevinll.company_service.repository.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    //Optional<Application> findByCode(Integer code);

    //boolean existsByCode(Integer code);
}

