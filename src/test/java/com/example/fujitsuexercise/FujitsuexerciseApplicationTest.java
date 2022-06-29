package com.example.fujitsuexercise;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.fujitsuexercise.client.Client;
import com.example.fujitsuexercise.client.ClientRepository;
import com.example.fujitsuexercise.movie.Movie;
import com.example.fujitsuexercise.movie.MovieGenre;
import com.example.fujitsuexercise.movie.MovieRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FujitsuexerciseApplication.class, ClientRepository.class, MovieRepository.class})
@ExtendWith(SpringExtension.class)
class FujitsuexerciseApplicationTest {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FujitsuexerciseApplication fujitsuexerciseApplication;

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Method under test: {@link FujitsuexerciseApplication#commandLineRunner(ClientRepository, MovieRepository)}
     */
    @Test
    void testCommandLineRunner() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commandLineRunner(ClientRepository, MovieRepository)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).commandLineRunner(mock(ClientRepository.class), mock(MovieRepository.class));
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#commandLineRunner(ClientRepository, MovieRepository)}
     */
    @Test
    void testCommandLineRunner2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commandLineRunner(ClientRepository, MovieRepository)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        fujitsuexerciseApplication.commandLineRunner(mock(ClientRepository.class), mock(MovieRepository.class));
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#commandLineRunner(ClientRepository, MovieRepository)}
     */
    @Test
    void testCommandLineRunner3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commandLineRunner(ClientRepository, MovieRepository)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).commandLineRunner(mock(ClientRepository.class), mock(MovieRepository.class));
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#commandLineRunner(ClientRepository, MovieRepository)}
     */
    @Test
    void testCommandLineRunner4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commandLineRunner(ClientRepository, MovieRepository)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        fujitsuexerciseApplication.commandLineRunner(mock(ClientRepository.class), mock(MovieRepository.class));
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#commandLineRunner(ClientRepository, MovieRepository)}
     */
    @Test
    void testCommandLineRunner5() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commandLineRunner(ClientRepository, MovieRepository)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).commandLineRunner(mock(ClientRepository.class), mock(MovieRepository.class));
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#commandLineRunner(ClientRepository, MovieRepository)}
     */
    @Test
    void testCommandLineRunner6() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commandLineRunner(ClientRepository, MovieRepository)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        fujitsuexerciseApplication.commandLineRunner(mock(ClientRepository.class), mock(MovieRepository.class));
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateMovies(MovieRepository)}
     */
    @Test
    void testGenerateMovies() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Movie movie = new Movie();
        movie.setActors("Actors");
        movie.setDescription("The characteristics of someone or something");
        movie.setDirector("Director");
        movie.setGenre(MovieGenre.COMEDY);
        movie.setId(123L);
        movie.setReleaseDate(LocalDate.ofEpochDay(1L));
        movie.setRentedByClients(new ArrayList<>());
        movie.setTimesRented(1);
        movie.setTitle("Dr");
        MovieRepository movieRepository1 = mock(MovieRepository.class);
        when(movieRepository1.save((Movie) any())).thenReturn(movie);
        fujitsuexerciseApplication1.generateMovies(movieRepository1);
        verify(movieRepository1, atLeast(1)).save((Movie) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateMovies(MovieRepository)}
     */
    @Test
    void testGenerateMovies2() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Movie movie = new Movie();
        movie.setActors("Actors");
        movie.setDescription("The characteristics of someone or something");
        movie.setDirector("Director");
        movie.setGenre(MovieGenre.COMEDY);
        movie.setId(123L);
        movie.setReleaseDate(LocalDate.ofEpochDay(1L));
        movie.setRentedByClients(new ArrayList<>());
        movie.setTimesRented(1);
        movie.setTitle("Dr");
        MovieRepository movieRepository1 = mock(MovieRepository.class);
        when(movieRepository1.save((Movie) any())).thenReturn(movie);
        fujitsuexerciseApplication1.generateMovies(movieRepository1);
        verify(movieRepository1, atLeast(1)).save((Movie) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateMovies(MovieRepository)}
     */
    @Test
    void testGenerateMovies3() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Movie movie = new Movie();
        movie.setActors("Actors");
        movie.setDescription("The characteristics of someone or something");
        movie.setDirector("Director");
        movie.setGenre(MovieGenre.COMEDY);
        movie.setId(123L);
        movie.setReleaseDate(LocalDate.ofEpochDay(1L));
        movie.setRentedByClients(new ArrayList<>());
        movie.setTimesRented(1);
        movie.setTitle("Dr");
        MovieRepository movieRepository1 = mock(MovieRepository.class);
        when(movieRepository1.save((Movie) any())).thenReturn(movie);
        fujitsuexerciseApplication1.generateMovies(movieRepository1);
        verify(movieRepository1, atLeast(1)).save((Movie) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Client client = new Client();
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication1.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients2() {
        Client client = new Client();
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients3() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Client client = new Client("Jane", "Doe", "jane.doe@example.org", "iloveyou", LocalDate.ofEpochDay(20L),
                MovieGenre.COMEDY);
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication1.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients4() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Client client = new Client();
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication1.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients5() {
        Client client = new Client();
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients6() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Client client = new Client("Jane", "Doe", "jane.doe@example.org", "iloveyou", LocalDate.ofEpochDay(20L),
                MovieGenre.COMEDY);
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication1.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients7() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Client client = new Client(123L, "Jane", "Doe", "jane.doe@example.org", "iloveyou", LocalDate.ofEpochDay(20L),
                MovieGenre.COMEDY);
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication1.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#generateClients(ClientRepository)}
     */
    @Test
    void testGenerateClients8() {
        FujitsuexerciseApplication fujitsuexerciseApplication1 = new FujitsuexerciseApplication();

        Client client = new Client();
        client.setDob(LocalDate.ofEpochDay(1L));
        client.setEmail("jane.doe@example.org");
        client.setFavGenre(MovieGenre.COMEDY);
        client.setFirstName("Jane");
        client.setId(123L);
        client.setInvoices(new ArrayList<>());
        client.setLastName("Doe");
        client.setPassword("iloveyou");
        client.setRentedMovies(new ArrayList<>());
        ClientRepository clientRepository1 = mock(ClientRepository.class);
        when(clientRepository1.save((Client) any())).thenReturn(client);
        fujitsuexerciseApplication1.generateClients(clientRepository1);
        verify(clientRepository1, atLeast(1)).save((Client) any());
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#movieGenreRandomPicker()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMovieGenreRandomPicker() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        (new FujitsuexerciseApplication()).movieGenreRandomPicker();
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#movieGenreRandomPicker()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMovieGenreRandomPicker2() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        (new FujitsuexerciseApplication()).movieGenreRandomPicker();
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#movieGenreRandomPicker()}
     */
    @Test
    void testMovieGenreRandomPicker3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by movieGenreRandomPicker()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).movieGenreRandomPicker();
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#randomDateGenerator()}
     */
    @Test
    void testRandomDateGenerator() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by randomDateGenerator()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).randomDateGenerator();
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#randomDateGenerator()}
     */
    @Test
    void testRandomDateGenerator2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by randomDateGenerator()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).randomDateGenerator();
    }

    /**
     * Method under test: {@link FujitsuexerciseApplication#randomDateGenerator()}
     */
    @Test
    void testRandomDateGenerator3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by randomDateGenerator()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new FujitsuexerciseApplication()).randomDateGenerator();
    }
}

