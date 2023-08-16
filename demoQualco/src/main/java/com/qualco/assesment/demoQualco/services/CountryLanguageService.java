package com.qualco.assesment.demoQualco.services;

import com.qualco.assesment.demoQualco.dao.CountryLanguageRepository;
import com.qualco.assesment.demoQualco.entity.Country;
import com.qualco.assesment.demoQualco.entity.CountryLanguage;
import com.qualco.assesment.demoQualco.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryLanguageService {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    public List<Language> getLanguagesForCountry(Country country) {
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findByCountry(country);
        return countryLanguages.stream()
                .map(CountryLanguage::getLanguage)
                .collect(Collectors.toList());
    }
}
