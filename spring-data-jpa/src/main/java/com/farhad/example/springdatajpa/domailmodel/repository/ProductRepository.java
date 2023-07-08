package com.farhad.example.springdatajpa.domailmodel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.domailmodel.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<Product> findByName(String name);
}
