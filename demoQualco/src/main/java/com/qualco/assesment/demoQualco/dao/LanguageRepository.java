package com.qualco.assesment.demoQualco.dao;

import com.qualco.assesment.demoQualco.entity.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Page<Language> findByLanguageId(@Param("id") Long id, Pageable pageable);

}
