package com.qualco.assesment.demoQualco.dao;

import com.qualco.assesment.demoQualco.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country, Long> {
    Page<Country> findById(@Param("id") Long id, Pageable pageable);
}
