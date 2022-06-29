package com.example.fujitsuexercise.client;

import com.example.fujitsuexercise.invoice.InvoiceRepository;
import com.example.fujitsuexercise.invoice.InvoiceService;
import com.example.fujitsuexercise.movie.MovieGenre;
import com.example.fujitsuexercise.movie.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ClientServiceTest {

    ClientService underTest;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private  ClientRepository clientRepository;
    @Autowired
    private MovieRepository movieRepository;


    @BeforeEach
    void setUp() {
        underTest = new ClientService(clientRepository, movieRepository, invoiceService);
    }

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void showAllClients() {
    }

    @Test
    void saveClient() {
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        
    }

    @Test
    void updateClientById() {
    }

    @Test
    void updatePasswordByClientId() {
    }

    @Test
    void deleteClientById() {
    }

    @Test
    void getClientById() {
    }

    @Test
    void showMoviesByClientFavGenreAndClientId() {
    }

    @Test
    void showClientRentedMoviesByClientId() {
    }

    @Test
    void showClientInvoicesByClientId() {
    }

    @Test
    void rentAMovieByMovieIdWithClientId() {
    }

    @Test
    void returnMovieByIdWithClientId() {
    }
}