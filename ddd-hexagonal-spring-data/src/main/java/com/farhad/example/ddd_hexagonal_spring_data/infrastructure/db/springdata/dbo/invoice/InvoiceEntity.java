package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.LineItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "invoices")
@NoArgsConstructor
public class InvoiceEntity {

    private String number;

    
    @ElementCollection
    @CollectionTable(name = "invoice_line_items", joinColumns = @JoinColumn(name = "invoice_id"))
    @OrderColumn(name = "line_items_row")
    private List<LineItem> lineItems = new ArrayList<>();

    public InvoiceEntity(String number) {
        this.number = number;
    }

    
}
