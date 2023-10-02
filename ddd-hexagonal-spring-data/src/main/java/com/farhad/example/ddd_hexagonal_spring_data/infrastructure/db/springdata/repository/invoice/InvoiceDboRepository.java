package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.invoice;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Invoice;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.InvoiceRepository;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice.InvoiceEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvoiceDboRepository implements InvoiceRepository {

    private final SpringDataInvoiceRepository repository;
    private final InvoiceEntityMapper invoiceEntityMapper;
    
    
    @Override
    public Optional<Invoice> findById(Long id) {
        return repository.findById(id)
                    .map(invoiceEntity -> invoiceEntityMapper.toDomain(invoiceEntity));
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceEntityMapper.toDomain(
                        repository.save(
                            invoiceEntityMapper.toDbo(invoice)));       
    }
    
}
