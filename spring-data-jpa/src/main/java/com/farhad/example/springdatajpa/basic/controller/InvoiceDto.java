package com.farhad.example.springdatajpa.basic.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InvoiceDto {
    
    private String clientId;
    private String currency;
    private BigDecimal amount;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
}
