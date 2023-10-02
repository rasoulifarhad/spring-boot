package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.LineItem;

import lombok.Data;

@Entity
@Data
@Table(name = "invoices")

public class InvoiceEntity {

    private String number;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn
    private List<LineItem> lineItems = new ArrayList<>();

    public InvoiceEntity(String number) {
        this.number = number;
    }

    
}
