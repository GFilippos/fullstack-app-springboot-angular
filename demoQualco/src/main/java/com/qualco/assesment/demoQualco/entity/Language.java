package com.qualco.assesment.demoQualco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "languages")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "language")
    private String language;

    @OneToMany(mappedBy = "language")
    private Set<CountryLanguage> countryLanguages;
}
