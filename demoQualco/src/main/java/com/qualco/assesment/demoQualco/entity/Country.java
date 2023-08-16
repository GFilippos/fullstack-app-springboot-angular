package com.qualco.assesment.demoQualco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="countries")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="area")
    private Double area;

    @Column(name="national_day")
    private Date nationalDay;

    @Column(name="country_code2")
    private String countryCode2;

    @Column(name="country_code3")
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "country")
    private Set<CountryLanguage> countryLanguages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<CountryStat> countryStats;
}
