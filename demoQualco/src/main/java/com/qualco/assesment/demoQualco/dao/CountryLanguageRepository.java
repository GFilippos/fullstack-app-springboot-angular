package com.qualco.assesment.demoQualco.dao;

import com.qualco.assesment.demoQualco.entity.Country;
import com.qualco.assesment.demoQualco.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, Long> {

    List<CountryLanguage> findByCountry(Country country);
}
