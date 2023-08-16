package com.qualco.assesment.demoQualco.controllers;

import com.qualco.assesment.demoQualco.dto.MaxRatioResultDTO;
import com.qualco.assesment.demoQualco.services.CountryStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/qualco")
public class CountryStatsController {

    @Autowired
    private CountryStatsService countryStatsService;

    @GetMapping("/max-ratios")
    public ResponseEntity<List<MaxRatioResultDTO>> getMaxGdpToPopulationRatios() {
        List<MaxRatioResultDTO> results = countryStatsService.findMaxGdpToPopulationRatios();
        return ResponseEntity.ok(results);
    }
}
