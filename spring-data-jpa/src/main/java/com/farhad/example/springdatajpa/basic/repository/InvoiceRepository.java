package com.farhad.example.springdatajpa.basic.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.basic.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    
}
