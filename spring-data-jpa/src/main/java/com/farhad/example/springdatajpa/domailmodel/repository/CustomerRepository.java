package com.farhad.example.springdatajpa.domailmodel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.domailmodel.Customer;
import com.farhad.example.springdatajpa.domailmodel.Product;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
    void addProduct(Product product, Long customerId);
    void deleteProduct(Product product, Long customerId);
}
