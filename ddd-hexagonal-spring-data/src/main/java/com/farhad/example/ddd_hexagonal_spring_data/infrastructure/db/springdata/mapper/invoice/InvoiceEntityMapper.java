package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice;

import org.mapstruct.Mapper;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Invoice;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.InvoiceEntity;

@Mapper(componentModel = "spring", uses = {LineItemEntityMapper.class})
public interface InvoiceEntityMapper {
    InvoiceEntity toDbo(Invoice invoice);
    Invoice toDomain(InvoiceEntity invoiceEntity);
}
