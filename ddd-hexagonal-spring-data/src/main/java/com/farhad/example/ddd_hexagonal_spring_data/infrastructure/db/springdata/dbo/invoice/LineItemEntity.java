package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.NonNull;

@Entity
public class LineItemEntity {
    
    @NonNull
    @ManyToOne
    private ProductEntity product;

    private Integer quantity;

    public LineItemEntity(@NonNull ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    
}
