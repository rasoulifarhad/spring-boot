package com.farhad.example.springdatajpa.domailmodel.dao;

import java.util.Optional;

import com.farhad.example.springdatajpa.domailmodel.Product;

public interface ProductDao {
    
    Optional<Product> findByName(String name);
    Product save(Product product);
    Product update(Product product);
}
