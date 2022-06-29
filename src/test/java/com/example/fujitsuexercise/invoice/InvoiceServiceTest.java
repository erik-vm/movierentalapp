package com.example.fujitsuexercise.invoice;

import com.example.fujitsuexercise.client.Client;
import com.example.fujitsuexercise.client.ClientRepository;
import com.example.fujitsuexercise.movie.Movie;
import com.example.fujitsuexercise.movie.MovieGenre;
import com.example.fujitsuexercise.movie.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class InvoiceServiceTest {

    InvoiceService underTest;
    @Autowired
   private InvoiceRepository invoiceRepository;
    @Autowired
    private  ClientRepository clientRepository;
    @Autowired
    private  MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        underTest = new InvoiceService(invoiceRepository, clientRepository, movieRepository);
    }

    @AfterEach
    void tearDown() {
        invoiceRepository.deleteAll();
    }

    @Test
    void saveNewInvoice() {
        //given
        Movie movie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);

        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        Invoice invoice = new Invoice(client, movie, LocalDate.now(), movie.getPrice(3L));

        movieRepository.save(movie);
        clientRepository.save(client);
        invoiceRepository.save(invoice);

        //when
        boolean successfulSave = false;
        if (underTest.invoiceList().contains(invoice)){
            successfulSave = true;
        }

        //then
        assertTrue(successfulSave);
    }

    @Test
    void invoiceList() {
        //given
        Movie movie = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 0);

        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        Invoice invoice1 = new Invoice(client, movie, LocalDate.now(), movie.getPrice(3L));
        Invoice invoice2 = new Invoice(client, movie, LocalDate.now(), movie.getPrice(3L));
        Invoice invoice3 = new Invoice(client, movie, LocalDate.now(), movie.getPrice(3L));

        movieRepository.save(movie);
        clientRepository.save(client);
        invoiceRepository.saveAll(Arrays.asList(invoice1, invoice2, invoice3));

        //when
        boolean successfulSave = false;
        if (underTest.invoiceList().size() == 3){
            successfulSave = true;
        }

        //then
        assertTrue(successfulSave);
    }

    }