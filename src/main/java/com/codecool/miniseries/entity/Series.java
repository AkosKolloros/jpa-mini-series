package com.codecool.miniseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Singular
    @ElementCollection
    @EqualsAndHashCode.Exclude
    private List<Genre> genres;

    @ElementCollection
    private List<String> createdBy;

    @Singular
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<Season> seasons;
}
