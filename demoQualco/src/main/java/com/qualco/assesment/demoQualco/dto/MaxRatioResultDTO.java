package com.qualco.assesment.demoQualco.dto;

import com.qualco.assesment.demoQualco.entity.Country;
import lombok.Data;

@Data
public class MaxRatioResultDTO {
        private String country;
        private Long maxRatio;

        private Long population;

        private Long year;

        private Long gdp;

        private String countryName;

        private String countryCode3;
}
