package com.qualco.assesment.demoQualco.embededId;

import com.qualco.assesment.demoQualco.entity.Country;
import com.qualco.assesment.demoQualco.entity.Language;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class CountryLanguageId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
}
