package com.qualco.assesment.demoQualco.dao;

import com.qualco.assesment.demoQualco.entity.CountryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface CountryStatRepository extends JpaRepository<CountryStat, Long> {

//    @Query("SELECT c, MAX(cs.gdp / cs.population), cs.year, cs.gdp, cs.population " +
//            "FROM CountryStat cs " +
//            "JOIN cs.country c " +
//            "GROUP BY c " +
//            "ORDER BY MAX(cs.gdp / cs.population) DESC")
    @Query("SELECT c.name, c.countryCode3, MAX(cs.gdp / cs.population), cs.year, cs.gdp, cs.population " +
        "FROM CountryStat cs " +
        "JOIN cs.country c " +
        "GROUP BY c.name, c.countryCode3 " + // Group by additional fields
        "ORDER BY MAX(cs.gdp / cs.population) DESC")
    List<Object[]> findMaxGdpToPopulationRatios();
}
