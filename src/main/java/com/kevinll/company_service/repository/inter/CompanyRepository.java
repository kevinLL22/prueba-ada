package com.kevinll.company_service.repository.inter;


import org.springframework.data.jpa.repository.JpaRepository;
import com.kevinll.company_service.repository.entity.Company;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Métodos CRUD ya incluidos: findAll, findById, save, deleteById...

    @Query(value = """
            SELECT c.idCompany AS id, COUNT(*) AS total
            FROM company c
            GROUP BY c.idCompany
            HAVING COUNT(*) > 1
            """, nativeQuery = true)
    List<DuplicateIdProjection> findDuplicateIds();
}


