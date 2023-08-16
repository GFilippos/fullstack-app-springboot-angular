package com.qualco.assesment.demoQualco.entity;

import com.qualco.assesment.demoQualco.embededId.CountryLanguageId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="country_languages")
@Data
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable=false, updatable=false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "language_id", insertable=false, updatable=false)
    private Language language;

    @Column(name = "official")
    private Integer official;
}
