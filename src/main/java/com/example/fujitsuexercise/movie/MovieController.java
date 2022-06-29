package com.example.fujitsuexercise.movie;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    List<Movie> showAllMovies() {
        return movieService.showAllMovies();
    }

    @GetMapping("/genre={moviegenre}")
    List<Movie> showMovieByGenre(@PathVariable("moviegenre") String genre) {
        return movieService.getMovieByGenre(genre);
    }

    @GetMapping("/id={movieId}")
    Movie getMovieById(@PathVariable("movieId") Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/rented_desc")
    List<Movie> showMoviesByRentedTimesDesc() {
        return movieService.sortByTimesRentedDesc();
    }

    @PostMapping
    Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PutMapping("/update/id={movieId}")
    Movie updateMovie(@PathVariable("movieId") Long id, @RequestBody Movie movie) {
        return movieService.updateMoveByMovieId(id, movie);
    }

    @DeleteMapping("/delete/id={movieId}")
    void deleteMovieById(@PathVariable("movieId") Long id) {
        movieService.deleteMovieById(id);
    }
}
