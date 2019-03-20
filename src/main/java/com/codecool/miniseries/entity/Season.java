package com.codecool.miniseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int numberOfEpisodes;

    @Column(length = 8000)
    private String description;

    @ManyToOne
    private Series series;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<Episode> episodes;
}
