package com.kevinll.company_service.repository.inter;

import com.kevinll.company_service.repository.entity.Company;
import com.kevinll.company_service.repository.entity.TmpC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursorRepository extends JpaRepository<TmpC, Integer> {
}
