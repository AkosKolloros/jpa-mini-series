package com.codecool.miniseries.repository;

import com.codecool.miniseries.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
