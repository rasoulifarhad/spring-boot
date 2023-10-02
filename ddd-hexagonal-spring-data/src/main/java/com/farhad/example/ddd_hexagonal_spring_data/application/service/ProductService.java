package com.farhad.example.ddd_hexagonal_spring_data.application.service;

import java.util.Optional;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Product;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}
