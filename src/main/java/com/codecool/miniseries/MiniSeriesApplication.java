package com.codecool.miniseries;

import com.codecool.miniseries.entity.Episode;
import com.codecool.miniseries.entity.Genre;
import com.codecool.miniseries.entity.Season;
import com.codecool.miniseries.entity.Series;
import com.codecool.miniseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
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
            Episode episode1 = Episode.builder()
                    .title("Pilot")
                    .originalAirDate(LocalDate.of(2013, 12, 2))
                    .directedBy("Justin Roiland")
                    .build();

            Episode episode2 = Episode.builder()
                    .title("Lawnmover Dog")
                    .originalAirDate(LocalDate.of(2013, 12, 9))
                    .directedBy("John Rice")
                    .build();

            Season season1 = Season.builder()
                    .title("Season 1")
                    .description("Rick convinces his daughter, Beth, and his son-in-law, Jerry, to allow their son, " +
                            "Morty, to continue following him in his interdimensional adventures, promising that this" +
                            " will improve his school performance. Morty, his parents and his sister, Summer, are " +
                            "dragged into dangerous adventures throughout the multiverse, which they manage to escape" +
                            " mostly thanks to Rick's ingenuity. When Rick and Morty accidentally turn the population" +
                            " of Earth into monsters, they move to an alternate dimension where the disaster was " +
                            "averted, leaving Beth, Jerry and Summer behind. They adapt to a seemingly identical " +
                            "reality, as they take the place of alternate versions of themselves who died moments " +
                            "before their arrival. It is revealed that Rick keeps using Morty as his companion, " +
                            "because his inferior brain waves neutralize Rick's genius brain waves, making him " +
                            "undetectable. When Beth and Jerry go on vacation, Rick and the kids have a party with " +
                            "numerous guests that turn the house into a mess. Rick freezes time so that he and the " +
                            "kids can repair the house, before their parents return.")
                    .episode(episode1)
                    .episode(episode2)
                    .numberOfEpisodes(11)
                    .build();

            Season season2 = Season.builder()
                    .title("Season 2")
                    .description("Six months later, Rick unfreezes time but ends up with his grandkids in a decaying " +
                            "dimension, split into numerous timelines. In one of them, Rick sacrifices himself to " +
                            "save Morty's life, but ultimately all three of them manage to get out safe. As Rick and " +
                            "Morty continue going on adventures, Morty faces moral dilemmas concerning freedom and " +
                            "the value of life, while Rick is depressed about his loneliness and old age. Earth " +
                            "becomes a protectorate of the Galactic Federation, an intergalactic organization against" +
                            " which Rick has rebelled. The Federation tries to arrest Rick, who goes into hiding " +
                            "along with the other members of the Smith family. Eventually, Rick turns himself in and " +
                            "is incarcerated in a maximum-security prison, in order to ensure the safety of his " +
                            "family. ")
                    .numberOfEpisodes(10)
                    .build();

            Series rickAndMorty = Series.builder()
                    .title("Rick and Morty")
                    .genre(Genre.ANIMATION)
                    .genre(Genre.SCIFI)
                    .genre(Genre.ADVENTURE)
                    .genre(Genre.COMEDY)
                    .createdBy(Arrays.asList("Justin Roiland", "Dan Harmon"))
                    .season(season1)
                    .season(season2)
                    .build();

            episode1.setSeason(season1);
            episode2.setSeason(season1);

            season1.setSeries(rickAndMorty);
            season2.setSeries(rickAndMorty);

            seriesRepository.save(rickAndMorty);
        };
    }
}
