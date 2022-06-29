package com.example.fujitsuexercise.client;

import com.example.fujitsuexercise.invoice.Invoice;
import com.example.fujitsuexercise.movie.Movie;
import com.example.fujitsuexercise.movie.MovieGenre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "client")
@Table(name = "client")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(name = "client_sequence", sequenceName = "client_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "client_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;
    @Column(name = "favourite_genre", nullable = false)
    private MovieGenre favGenre;
    @ManyToMany
    @JoinTable(
            name = "rented_movies",
            joinColumns = @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "rented_movies_client_id_fk")),
            inverseJoinColumns = @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "rented_movies_movie_id_fk")))
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    public List<Movie> rentedMovies = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    public List<Invoice> invoices = new ArrayList<>();

    public Client(Long id, String firstName, String lastName, String email, String password, LocalDate dob, MovieGenre favGenre) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.favGenre = favGenre;
    }

    public Client(String firstName, String lastName, String email, String password, LocalDate dob, MovieGenre favGenre) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.favGenre = favGenre;
    }

}


