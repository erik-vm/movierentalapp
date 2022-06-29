package com.example.fujitsuexercise;

import com.example.fujitsuexercise.client.Client;
import com.example.fujitsuexercise.client.ClientRepository;
import com.example.fujitsuexercise.invoice.InvoiceRepository;
import com.example.fujitsuexercise.movie.Movie;
import com.example.fujitsuexercise.movie.MovieGenre;
import com.example.fujitsuexercise.movie.MovieRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class FujitsuexerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FujitsuexerciseApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository, MovieRepository movieRepository) {
        return args -> {

            // generateClients(clientRepository);
            // generateMovies(movieRepository);

        };
    }

    //Generates movies with random data for database
    void generateMovies(MovieRepository movieRepository) {
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            Movie movie = new Movie(
                    faker.name().title(),
                    faker.name().firstName() + " " + faker.name().lastName(),
                    faker.name().firstName() + " " + faker.name().lastName() + ", " + faker.name().firstName() + " " + faker.name().lastName() + ", " + faker.name().firstName() + " " + faker.name().lastName(),
                    faker.lorem().sentence(),
                    randomDateGenerator(),
                    movieGenreRandomPicker()
                    , 0
            );
            movieRepository.save(movie);
        }
    }

    //Generates clients with random data for database
    void generateClients(ClientRepository clientRepository) {

        Faker faker = new Faker();

        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@fujitsu.com", firstName, lastName);

            Client client = new Client(firstName, lastName, email, faker.internet().password(6, 16), randomDateGenerator(), movieGenreRandomPicker());
            clientRepository.save(client);
        }

    }

    //Gives random movie genre
    MovieGenre movieGenreRandomPicker() {
        int randomNumber = (int) Math.abs(Math.random() * 15);
        MovieGenre movieGenre = null;
        switch (randomNumber) {
            case 0 -> movieGenre = MovieGenre.COMEDY;
            case 1 -> movieGenre = MovieGenre.SCI_FI;
            case 2 -> movieGenre = MovieGenre.HORROR;
            case 3 -> movieGenre = MovieGenre.ROMANCE;
            case 4 -> movieGenre = MovieGenre.ACTION;
            case 5 -> movieGenre = MovieGenre.THRILLER;
            case 6 -> movieGenre = MovieGenre.DRAMA;
            case 7 -> movieGenre = MovieGenre.MYSTERY;
            case 8 -> movieGenre = MovieGenre.CRIME;
            case 9 -> movieGenre = MovieGenre.ANIMATION;
            case 10 -> movieGenre = MovieGenre.ADVENTURE;
            case 11 -> movieGenre = MovieGenre.FANTASY;
            case 12 -> movieGenre = MovieGenre.COMEDY_ROMANCE;
            case 13 -> movieGenre = MovieGenre.ACTION_COMEDY;
            case 14 -> movieGenre = MovieGenre.SUPERHERO;
        }
        return movieGenre;
    }

    //Gives random date
    LocalDate randomDateGenerator() {
        Faker faker = new Faker();
        int year = faker.number().numberBetween(1962, 2021);
        int month = faker.number().numberBetween(1, 12);
        int day;
        if (month == 2) {
            day = faker.number().numberBetween(1, 28);
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = faker.number().numberBetween(1, 30);
        } else {
            day = faker.number().numberBetween(1, 31);
        }
        return LocalDate.of(year, month, day);
    }

}
