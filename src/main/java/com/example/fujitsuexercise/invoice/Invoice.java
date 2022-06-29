package com.example.fujitsuexercise.invoice;

import com.example.fujitsuexercise.client.Client;
import com.example.fujitsuexercise.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "invoice")
@Table(name = "invoice")
@Setter
@Getter
@NoArgsConstructor
public class Invoice {
    @Id
    @SequenceGenerator(name = "invoice_sequence", sequenceName = "invoice_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "invoice_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "clientt_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "client_invoice_fk"))
    private Client client;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "movie_invoice_fk"))
    private Movie movie;
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate createdAt;
    @Column(name = "total")
    private Double total;

    public Invoice(Client client, Movie movie, LocalDate createdAt, Double total) {
        this.client = client;
        this.movie = movie;
        this.createdAt = createdAt;
        this.total = total;
    }
}
