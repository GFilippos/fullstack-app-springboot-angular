package com.qualco.assesment.demoQualco.controllers;

import com.qualco.assesment.demoQualco.entity.Country;
import com.qualco.assesment.demoQualco.entity.Language;
import com.qualco.assesment.demoQualco.services.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/qualco")
public class CountryLanguageController {

    @Autowired
    private CountryLanguageService countryLanguageService;

    @GetMapping("/country/{countryId}/languages")
    public ResponseEntity<List<Language>> getLanguagesForCountry(@PathVariable Long countryId) {
        Country country = new Country();
        country.setId(countryId);

        List<Language> languages = countryLanguageService.getLanguagesForCountry(country);
        return ResponseEntity.ok(languages);
    }
}
