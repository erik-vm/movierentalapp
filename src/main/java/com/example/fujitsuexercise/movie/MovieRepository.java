package com.example.fujitsuexercise.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> getMovieByTitle(String title);

    List<Movie> getMovieByGenre(MovieGenre genre);


}
