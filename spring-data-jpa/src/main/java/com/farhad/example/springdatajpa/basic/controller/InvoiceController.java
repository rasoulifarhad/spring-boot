package com.farhad.example.springdatajpa.basic.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springdatajpa.basic.model.Invoice;
import com.farhad.example.springdatajpa.basic.service.InvoiceService;
import com.farhad.example.springdatajpa.basic.util.MoneyUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InvoiceController {
    
    private final InvoiceService invoiceService;

    @PostMapping(value = "/invoices/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceDto> createInvoice(@PathVariable("clientId") String clientId ) {
        Optional<Invoice> optional = invoiceService.createClientInvoice(clientId, LocalDate.now());
        return optional
                    .map(this::toDto)
                    .map(dto -> ResponseEntity.ok(dto) )
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private InvoiceDto toDto(Invoice invoice) {
        return InvoiceDto.builder()
                    .amount(MoneyUtil.extractAmount(invoice.getTotal()))
                    .currency(MoneyUtil.extractCurrencyCode(invoice.getTotal()))
                    .clientId(invoice.getClientId())
                    .dueDate(invoice.getDueDate())
                    .invoiceDate(invoice.getInvoiceDate())
                    .build();
    }
}
