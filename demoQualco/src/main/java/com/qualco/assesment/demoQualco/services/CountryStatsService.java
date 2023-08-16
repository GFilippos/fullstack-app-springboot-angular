package com.qualco.assesment.demoQualco.services;

import com.qualco.assesment.demoQualco.dao.CountryStatRepository;
import com.qualco.assesment.demoQualco.dto.MaxRatioResultDTO;
import com.qualco.assesment.demoQualco.entity.Country;
import com.qualco.assesment.demoQualco.entity.CountryStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryStatsService {

    @Autowired
    private CountryStatRepository countryStatsRepository;

    public List<MaxRatioResultDTO> findMaxGdpToPopulationRatios() {
        List<Object[]> results = countryStatsRepository.findMaxGdpToPopulationRatios();

        List<MaxRatioResultDTO> ratiosList = new ArrayList<>();
        for (Object[] maxRatioResult : results) {

            String countryName = (String) maxRatioResult[0];
            String countryCode3 = (String) maxRatioResult[1];
            Long maxRatio = (Long) maxRatioResult[2];
            Long year = (Long) maxRatioResult[3];
            Long gdp = (Long) maxRatioResult[4];
            Long population = (Long) maxRatioResult[5];

            MaxRatioResultDTO ratioDTO = new MaxRatioResultDTO();

            ratioDTO.setCountryName(countryName);
            ratioDTO.setCountryCode3(countryCode3);
            ratioDTO.setMaxRatio(maxRatio);
            ratioDTO.setYear(year);
            ratioDTO.setGdp(gdp);
            ratioDTO.setPopulation(population);

            ratiosList.add(ratioDTO);
        }
        return ratiosList;
    }
}
