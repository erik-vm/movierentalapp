package com.example.fujitsuexercise.client;

import com.example.fujitsuexercise.invoice.Invoice;
import com.example.fujitsuexercise.movie.Movie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @GetMapping("/all")
    List<Client> showAllClients() {
        return clientService.showAllClients();
    }

    @GetMapping("/id={clientId}")
    Client getClientById(@PathVariable("clientId") Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/rentedmovies/id={clientId}")
    List<Movie> showClientRentedMoviesByClientId(@PathVariable("clientId") Long id) {
        return clientService.showClientRentedMoviesByClientId(id);
    }

    @GetMapping("/invoices/id={clientId}")
    List<Invoice> showClientInvoicesByClientId(@PathVariable("clientId") Long id) {
        return clientService.showClientInvoicesByClientId(id);
    }

    @GetMapping("/id={clientId}/favgenre")
    List<Movie> showMoviesByClientFavGenreAndClientId(@PathVariable("clientId") Long id) {
        return clientService.showMoviesByClientFavGenreAndClientId(id);
    }

    @PostMapping
    Client saveNewClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/id={clientId}")
    Client updateClient(@PathVariable("clientId") Long id, @RequestBody Client client) {
        return clientService.updateClientById(id, client);
    }

    @PutMapping("id={clientId}/password={password}")
    Client updatePasswordByClientId(@PathVariable("clientId") Long id, @PathVariable("password") String newPassword) {
        return clientService.updatePasswordByClientId(id, newPassword);
    }

    @PutMapping("rentmovie/clientid={clientId}/movieid={movieId}/weeks={weeksToRent}")
    void rentAMovieByMovieIdWithClientId(@PathVariable("clientId") Long clientId, @PathVariable("movieId") Long movieId, @PathVariable("weeksToRent") Long weeksToRent, Invoice invoice) {
        clientService.rentAMovieByMovieIdWithClientId(clientId, movieId, weeksToRent);
    }

    @PutMapping("returnmovie/clientid={clientId}/movieid={movieId}")
    void returnMovieByMovieIdWithClientId(@PathVariable("clientId") Long clientId, @PathVariable("movieId") Long movieId) {
        clientService.returnMovieByIdWithClientId(clientId, movieId);
    }

    @DeleteMapping("/delete/id={clientId}")
    void deleteClientById(@PathVariable("clientId") Long id) {
        clientService.deleteClientById(id);
    }
}
