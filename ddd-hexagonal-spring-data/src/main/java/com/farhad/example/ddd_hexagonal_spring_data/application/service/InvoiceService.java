package com.farhad.example.ddd_hexagonal_spring_data.application.service;

import java.util.Optional;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Invoice;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceService {
    
    private final InvoiceRepository invoiceRepository;    

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getProductById(Long id) {
        return invoiceRepository.findById(id);
    }

}
