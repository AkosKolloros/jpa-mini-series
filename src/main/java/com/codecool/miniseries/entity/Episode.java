package com.codecool.miniseries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String directedBy;

    private LocalDate originalAirDate;

    @Transient
    private long age;

    @ManyToOne
    private Season season;

    public void calculateAge() {
        if (originalAirDate != null) {
            age = ChronoUnit.YEARS.between(originalAirDate, LocalDate.now());
        }
    }
}
