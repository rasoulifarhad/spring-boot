package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {
    
    private Product product;

    private Integer quantity;
}
