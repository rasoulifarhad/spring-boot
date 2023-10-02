package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Product save(Product product);

}
