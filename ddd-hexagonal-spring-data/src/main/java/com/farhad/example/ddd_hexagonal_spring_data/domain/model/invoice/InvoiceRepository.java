package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import java.util.Optional;

public interface InvoiceRepository {
 
    Optional<Invoice> findById(Long id);
    Invoice save(Invoice invoice);
}
