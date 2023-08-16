package com.qualco.assesment.demoQualco.entity;

import com.qualco.assesment.demoQualco.embededId.CountryStatsId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "country_stats")
@Data
@IdClass(CountryStatsId.class)
public class CountryStat {

    @Id
    @Column(name = "year")
    private Long year;

    @Id
    @Column(name = "population")
    private Long population;

    @Column(name = "gdp")
    private Long gdp;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
