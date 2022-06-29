package com.example.fujitsuexercise.movie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieServiceTest {

    private MovieService underTest;
    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        underTest = new MovieService(movieRepository);
    }

    @AfterEach
    void tearDown() {
        movieRepository.deleteAll();
    }

    @Test
    void showAllMovies() {
        //given
        Movie movie1 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);

        Movie movie2 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);

        Movie movie3 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));

        //when
        boolean searchSuccessful = false;
        if (underTest.showAllMovies().size() == 3){
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);
    }

    @Test
    void saveMovie() {
        //given
        Movie movie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);
        movieRepository.save(movie);

        //when
        boolean saveSuccessful = false;
        if (underTest.getMovieById(movie.getId()) != null) {
            saveSuccessful = true;
        }
        //then
        assertTrue(saveSuccessful);
    }

    @Test
    void updateMoveByMovieId() {
        //given
        Movie movie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);
        movieRepository.save(movie);

        //when
        //updated genre from COMEDY to DRAMA
        Movie updatedMovie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.DRAMA, 0);

        boolean updateSuccessful = false;

        underTest.updateMoveByMovieId(movie.getId(), updatedMovie);
        if (movie.getGenre().equals(MovieGenre.DRAMA)) {
            updateSuccessful = true;
        }

        //then
        assertTrue(updateSuccessful);
    }

    @Test
    void deleteMovieById() {
        //given
        Movie movie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);
        movieRepository.save(movie);

        //when
        boolean deleteSuccessful = false;

        if (underTest.getMovieById(movie.getId()) != null) {
            underTest.deleteMovieById(movie.getId());
        }
        if (!underTest.doesMovieExistById(movie.getId())) {
            deleteSuccessful = true;
        }
        //then
        assertTrue(deleteSuccessful);
    }

    @Test
    void getMoviesByGenre() {
        //given
        Movie movie1 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);

        Movie movie2 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);

        Movie movie3 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));

        //when
        boolean searchSuccessful = false;
        if (underTest.getMovieByGenre("COMEDY").size() == 3){
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);

    }

    @Test
    void getMovieById() {
        Movie movie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);
        movieRepository.save(movie);

        //when
        boolean searchSuccessful = false;
        if (underTest.getMovieById(movie.getId()).equals(movie)){
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);
    }

    @Test
    void sortByTimesRentedDesc() {
        //given
        Movie movie1 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 7);

        Movie movie2 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 3);

        Movie movie3 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 5);
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));

        //when
        List<Movie> movieList = underTest.sortByTimesRentedDesc();
        boolean searchSuccessful = false;
        if (movieList.get(0).equals(movie1)  && movieList.get(1).equals(movie3) && movieList.get(2).equals(movie2) ){
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);
    }

}