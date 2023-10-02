package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineItem {
    
    private Product productId;

    private Integer quantity;
}
