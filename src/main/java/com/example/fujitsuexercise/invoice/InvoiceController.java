package com.example.fujitsuexercise.invoice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/all")
    List<Invoice> showAllInvoices() {
        return invoiceService.invoiceList();
    }

    @PostMapping("/client={clientId}/movie={movieId}/weeks={weeksToRent}")
    Invoice saveNewInvoice(@PathVariable("clientId") Long clientId, @PathVariable("movieId") Long movieId
            , @PathVariable("weeksToRent") Long weeks) {
        return invoiceService.saveNewInvoice(clientId, movieId, weeks);
    }
}
