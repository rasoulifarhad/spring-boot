package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.invoice;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Product;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.ProductRepository;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice.ProductEntityMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductDboRepository implements ProductRepository {
    
    private final SpringDataProductRepository repository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                    .map(e -> productEntityMapper.toDomain(e)); 
    }

    @Override
    public Product save(Product product) {
        return productEntityMapper.toDomain(
                        repository.save(
                            productEntityMapper.toDbo(product)));
    }


}
