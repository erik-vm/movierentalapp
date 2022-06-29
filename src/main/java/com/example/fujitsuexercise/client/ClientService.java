package com.example.fujitsuexercise.client;

import com.example.fujitsuexercise.invoice.Invoice;
import com.example.fujitsuexercise.invoice.InvoiceService;
import com.example.fujitsuexercise.movie.Movie;
import com.example.fujitsuexercise.movie.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final MovieRepository movieRepository;
    private final InvoiceService invoiceService;


    List<Client> showAllClients() {
        if (clientRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return clientRepository.findAll();
    }

    Client saveClient(Client client) {
        for (Client c : clientRepository.findAll()) {
            if (c.getEmail().equals(client.getEmail())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }
        return clientRepository.save(client);
    }

    Client updateClientById(Long id, Client updatedClient) {
        Client clientToUpdate = getClientById(id);

        clientToUpdate.setFirstName(updatedClient.getFirstName());
        clientToUpdate.setLastName(updatedClient.getLastName());
        clientToUpdate.setEmail(updatedClient.getEmail());
        clientToUpdate.setPassword(updatedClient.getPassword());
        clientToUpdate.setDob(updatedClient.getDob());
        clientToUpdate.setFavGenre(updatedClient.getFavGenre());

        return clientRepository.save(clientToUpdate);
    }

    Client updatePasswordByClientId(Long id, String newPassword) {
        Client client = getClientById(id);
        client.setPassword(newPassword);
        return clientRepository.save(client);
    }

    void deleteClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        clientRepository.deleteById(id);
    }

    Client getClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clientOptional.get();
    }

    //Shows movies depending on clients favorite movie genre
    List<Movie> showMoviesByClientFavGenreAndClientId(Long id) {
        Client client = getClientById(id);
        List<Movie> clientFavMovies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getGenre().equals(client.getFavGenre())) {
                clientFavMovies.add(movie);
            }
        }
        return clientFavMovies;
    }

    //Shows movies client is currently renting.
    List<Movie> showClientRentedMoviesByClientId(Long id) {
        Client client = getClientById(id);
        if (client.getRentedMovies().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return client.getRentedMovies();
    }

    //Shows clients all invoices
    List<Invoice> showClientInvoicesByClientId(Long id) {
        Client client = getClientById(id);
        List<Invoice> clientInvoices = new ArrayList<>();
        for (Invoice invoice : invoiceService.invoiceList()) {
            if (invoice.getClient() == client) {
                clientInvoices.add(invoice);
            }
        }
        if (clientInvoices.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return clientInvoices;
    }

    //Movie renting method. For renting needs id of a movie and client and for how long movie is going to be rented.
    //When exception is not thrown, invoice ise saved through invoice server class. Invoice will be generated with
    //client id, movie id, issue date and amount to pay. Rented movie total rented times is increased by one and lists
    //in movie and client class have been updated.
    void rentAMovieByMovieIdWithClientId(Long clientId, Long movieId, Long weeksToRent) {
        getClientById(clientId);
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        invoiceService.saveNewInvoice(clientId, movieId, weeksToRent);
    }

    //Movie returning method. Needs movie and client id. If exception is not thrown, movie is removed from clients
    //rented movies list and client ise removed from movies rented by clients list.
    void returnMovieByIdWithClientId(Long clientId, Long movieId) {
        Client client = getClientById(clientId);
        Movie movie = movieRepository.getById(movieId);
        if (!client.getRentedMovies().contains(movie)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        client.getRentedMovies().remove(movie);
        movie.getRentedByClients().remove(client);
        clientRepository.save(client);
        movieRepository.save(movie);

    }

}
