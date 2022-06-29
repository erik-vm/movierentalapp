package com.example.fujitsuexercise.client;

import com.example.fujitsuexercise.invoice.InvoiceRepository;
import com.example.fujitsuexercise.invoice.InvoiceService;
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
class ClientServiceTest {

    ClientService underTest;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MovieRepository movieRepository;


    @BeforeEach
    void setUp() {
        underTest = new ClientService(clientRepository, movieRepository, invoiceRepository);
    }

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void showAllClients() {
        //given
        Client client1 = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        Client client2 = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        Client client3 = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));

        //when
        boolean searchSuccessful = false;
        if (underTest.showAllClients().size() == 3) {
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);
    }

    @Test
    void saveClient() {
        //given
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        clientRepository.save(client);

        //when
        boolean saveSuccessful = false;
        if (underTest.getClientById(client.getId()) != null) {
            saveSuccessful = true;
        }
        //then
        assertTrue(saveSuccessful);
    }

    @Test
    void updateClientById() {
        //given
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        clientRepository.save(client);

        //when
        //updated genre from COMEDY to DRAMA
        Client updateClient = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.DRAMA);

        boolean updateSuccessful = false;

        underTest.updateClientById(client.getId(), updateClient);
        if (client.getFavGenre().equals(MovieGenre.DRAMA)) {
            updateSuccessful = true;
        }

        //then
        assertTrue(updateSuccessful);
    }

    @Test
    void updatePasswordByClientId() {
        //given
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        clientRepository.save(client);

        //when

        boolean updateSuccessful = false;
        String newPassword = "123456";
        underTest.updatePasswordByClientId(client.getId(), newPassword);
        if (client.getPassword().equals(newPassword)) {
            updateSuccessful = true;
        }

        //then
        assertTrue(updateSuccessful);
    }

    @Test
    void deleteClientById() {
        //given
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        clientRepository.save(client);

        //when
        boolean deleteSuccessful = false;

        if (underTest.getClientById(client.getId()) != null) {
            underTest.deleteClientById(client.getId());
        }
        if (!underTest.doesClientExist(client.getId())) {
            deleteSuccessful = true;
        }
        //then
        assertTrue(deleteSuccessful);
    }

    @Test
    void getClientById() {
        //given
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        clientRepository.save(client);

        //when
        boolean searchSuccessful = false;
        if (underTest.getClientById(client.getId()).equals(client)) {
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);
    }

    @Test
    void showMoviesByClientFavGenreAndClientId() {
        //given
        Client client = new Client("John", "Doe", "John.Doe@mail.com", "password", LocalDate.now().plusYears(20), MovieGenre.COMEDY);
        Movie movie1 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 7);

        Movie movie2 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 3);

        Movie movie3 = new Movie("Title", "Director", "Actors", "Lorem Ipsum",
                LocalDate.now().minusDays(14), MovieGenre.COMEDY, 5);
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
        clientRepository.save(client);

        //when
        boolean searchSuccessful = false;
        if (underTest.showMoviesByClientFavGenreAndClientId(client.getId()).size() == 3) {
            searchSuccessful = true;
        }

        //then
        assertTrue(searchSuccessful);
    }

}