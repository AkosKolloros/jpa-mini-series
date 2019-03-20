package com.codecool.miniseries;

import com.codecool.miniseries.entity.Genre;
import com.codecool.miniseries.entity.Series;
import com.codecool.miniseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class MiniSeriesApplication {

    @Autowired
    private SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiniSeriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Series rickAndMorty = Series.builder()
                    .title("Rick and Morty")
                    .genre(Genre.ANIMATION)
                    .genre(Genre.SCIFI)
                    .genre(Genre.ADVENTURE)
                    .genre(Genre.COMEDY)
                    .createdBy(Arrays.asList("Justin Roiland", "Dan Harmon"))
                    .build();

            seriesRepository.save(rickAndMorty);
        };
    }
}
