package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "products")
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ProductEntity {
    
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    @NotEmpty
    private String name;

    public ProductEntity(@NonNull @NotEmpty String name) {
        this.name = name;
    }

    
}
