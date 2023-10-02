package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.InvoiceEntity;

public interface SpringDataInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    
}
