package com.qualco.assesment.demoQualco.embededId;

import java.io.Serializable;
import java.util.Objects;

public class CountryStatsId implements Serializable {

    private Long year;
    private Long population;

    public CountryStatsId() {
    }

    public CountryStatsId(Long year, Long population) {
        this.year = year;
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryStatsId that = (CountryStatsId) o;
        return Objects.equals(population, that.population) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(population, year);
    }
}
