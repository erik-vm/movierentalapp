package com.example.fujitsuexercise.invoice;

import com.example.fujitsuexercise.client.Client;
import com.example.fujitsuexercise.client.ClientRepository;
import com.example.fujitsuexercise.movie.Movie;
import com.example.fujitsuexercise.movie.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;
    private final MovieRepository movieRepository;


  public Invoice saveNewInvoice(Long clientId, Long movieId, Long weeksToRent){
      Optional<Client> optionalClient = clientRepository.findById(clientId);
      Optional<Movie> optionalMovie = movieRepository.findById(movieId);

      if (optionalClient.isPresent() && optionalMovie.isPresent()){
          Invoice invoice = new Invoice();
          Client client =  optionalClient.get();
          Movie movie = optionalMovie.get();

          invoice.setClient(client);
          invoice.setMovie(movie);
          invoice.setCreatedAt(LocalDate.now());
          invoice.setTotal(movie.getPrice(weeksToRent));

          movie.setTimesRented(movie.getTimesRented()+1);
          movie.getRentedByClients().add(client);
          client.rentedMovies.add(movie);

          clientRepository.save(client);
          movieRepository.save(movie);
          return invoiceRepository.save(invoice);
      }
      throw new ResponseStatusException(HttpStatus.CONFLICT);
  }

    public List<Invoice> invoiceList(){
        if (invoiceRepository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return invoiceRepository.findAll();
    }
}
