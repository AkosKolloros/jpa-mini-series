package com.codecool.miniseries.repository;

import com.codecool.miniseries.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
