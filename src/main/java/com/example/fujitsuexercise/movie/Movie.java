package com.example.fujitsuexercise.movie;


import com.example.fujitsuexercise.client.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "movie")
@Table(name = "movie")
@Setter
@Getter
@NoArgsConstructor
public class Movie {
    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "movie_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(name = "director", nullable = false, columnDefinition = "TEXT")
    private String director;
    @Column(name = "actors", nullable = false, columnDefinition = "TEXT")
    private String actors;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "release_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    @Column(name = "genre", nullable = false, columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;
    @Column(name = "times_rented", nullable = false)
    private Integer timesRented;
    @ManyToMany(mappedBy = "rentedMovies")
    @JsonIgnore
    private List<Client> rentedByClients = new ArrayList<>();


    public Movie(String title, String director, String actors, String description, LocalDate releaseDate, MovieGenre genre, Integer timesRented) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.timesRented = timesRented;
    }

    public Movie(Long id, String title, String director, String actors, String description, LocalDate releaseDate, MovieGenre genre, Integer timesRented) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.timesRented = timesRented;
        this.rentedByClients = rentedByClients;
    }

    //Movie price is calculated depending on movies age. If movie is less than 52 weeks old,
    //Price per week is 5.00. If its between 54 -156 weeks old, price per week is 3.49. Above
    //156 weeks its 1.99 per week. If age class is changes turning rental period, the rental
    //period is divided to days and total price is calculated how many day's movie is in old
    //age class and how many in new.
    public Double getPrice(Long weeksToRent) {

        LocalDate newMovieClassUntil = this.getReleaseDate().plusWeeks(52);
        LocalDate regularMovieClassUntil = this.getReleaseDate().plusWeeks(156);

        Long daysTilChangeToRegularClass = ChronoUnit.DAYS.between(LocalDate.now(), newMovieClassUntil);
        Long daysTilChangeToOldClass = ChronoUnit.DAYS.between(LocalDate.now(), regularMovieClassUntil);

        Double price = 0D;
        Long rentTimeInDays = weeksToRent * 7;

        if (daysTilChangeToRegularClass > 0 && (daysTilChangeToRegularClass - rentTimeInDays > 0)) {
            price = weeksToRent * 5.00D;
        } else if (daysTilChangeToRegularClass > 0 && (daysTilChangeToRegularClass - rentTimeInDays < 0)) {
            price = weeksToRent * ((5.00 / rentTimeInDays * daysTilChangeToRegularClass) + (3.49 / rentTimeInDays * (rentTimeInDays - daysTilChangeToRegularClass)));
        } else if (daysTilChangeToRegularClass <= 0 && daysTilChangeToOldClass > 0 && (daysTilChangeToOldClass - rentTimeInDays > 0)) {
            price = weeksToRent * 3.49D;
        } else if (daysTilChangeToRegularClass <= 0 && daysTilChangeToOldClass > 0 && (daysTilChangeToOldClass - rentTimeInDays < 0)) {
            price = weeksToRent * ((3.49 / rentTimeInDays * daysTilChangeToOldClass) + (1.99 / rentTimeInDays * (rentTimeInDays - daysTilChangeToOldClass)));
        } else {
            price = 1.99D * weeksToRent;
        }

        return price;
    }
}
