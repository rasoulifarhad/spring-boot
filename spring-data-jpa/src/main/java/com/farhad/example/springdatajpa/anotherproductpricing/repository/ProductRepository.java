package com.farhad.example.springdatajpa.anotherproductpricing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.anotherproductpricing.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
