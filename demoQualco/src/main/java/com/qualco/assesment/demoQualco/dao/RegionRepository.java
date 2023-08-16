package com.qualco.assesment.demoQualco.dao;

import com.qualco.assesment.demoQualco.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface RegionRepository extends JpaRepository<Region, Long> {
}
