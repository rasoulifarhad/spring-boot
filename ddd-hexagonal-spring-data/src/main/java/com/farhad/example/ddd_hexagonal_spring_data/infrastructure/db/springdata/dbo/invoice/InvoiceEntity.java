package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "invoices")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InvoiceEntity {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private String number;

    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "invoice_line_items", joinColumns = @JoinColumn(name = "invoice_id"))
    @OrderColumn(name = "line_items_row")
    private List<LineItemEntity> lineItems = new ArrayList<>();

    public InvoiceEntity(String number) {
        this.number = number;
    }

    
}
