package com.farhad.example.springdatajpa.productpricing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.productpricing.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
