package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    
    public Product(@NonNull @NotEmpty String name) {
        this.name = name;
    }

    public Product(@NonNull Long id, @NonNull @NotEmpty String name) {
        this.id = id;
        this.name = name;

    }
    
}
