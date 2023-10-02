package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    
    private Long id;
    
    private String name;
    
    public Product(@NonNull @NotEmpty String name) {
        this.name = name;
    }

    
}
