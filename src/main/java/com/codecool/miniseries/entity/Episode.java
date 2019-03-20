package com.codecool.miniseries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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

    @ManyToOne
    private Season season;
}
