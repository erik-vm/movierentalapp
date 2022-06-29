package com.example.fujitsuexercise.movie;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    List<Movie> showAllMovies() {
        if (movieRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return movieRepository.findAll();
    }

    Movie saveMovie(Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.getMovieByTitle(movie.getTitle());
        if (optionalMovie.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return movieRepository.save(movie);
    }

    Movie updateMoveByMovieId(Long id, Movie updatedMovie) {
        Movie movieToUpdate = getMovieById(id);
        movieToUpdate.setTitle(updatedMovie.getTitle());
        movieToUpdate.setDirector(updatedMovie.getDirector());
        movieToUpdate.setActors(updatedMovie.getActors());
        movieToUpdate.setDescription(updatedMovie.getDescription());
        movieToUpdate.setReleaseDate(updatedMovie.getReleaseDate());
        movieToUpdate.setGenre(updatedMovie.getGenre());
        return movieRepository.save(movieToUpdate);
    }

    void deleteMovieById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        movieRepository.deleteById(id);
    }

    //Shows all movies in one genre.
    public List<Movie> getMovieByGenre(String genre) {
        if (movieRepository.getMovieByGenre(MovieGenre.valueOf(genre.toUpperCase())).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movieRepository.getMovieByGenre(MovieGenre.valueOf(genre.toUpperCase()));
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movieOptional.get();
    }

    //Gives movies list. Most rented ones are in the top. If equal times rented, then sorted by name.
   public List<Movie> sortByTimesRentedDesc() {
        return movieRepository.findAll(Sort.by("timesRented").descending().and(Sort.by("title").ascending()));
    }

    boolean doesMovieExistById(Long id){
        Optional <Movie> movieOptional = movieRepository.findById(id);
        return movieOptional.isPresent();
    }


}
