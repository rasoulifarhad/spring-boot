package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@NoArgsConstructor
public class LineItemEntity {
    
    @NonNull
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private ProductEntity product;

    private Integer quantity;

    public LineItemEntity(@NonNull ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    
}
