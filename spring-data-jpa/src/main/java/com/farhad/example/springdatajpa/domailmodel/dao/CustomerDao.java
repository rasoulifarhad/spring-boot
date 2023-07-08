package com.farhad.example.springdatajpa.domailmodel.dao;

import java.util.Optional;

import com.farhad.example.springdatajpa.domailmodel.domain.Customer;
import com.farhad.example.springdatajpa.domailmodel.domain.Product;

public interface CustomerDao {
    
    Optional<Customer> findByName(String name);
    void addProduct(Product product, Customer customer);
    void deleteProduct(Product product, Customer customer);

    Customer save(Customer customer);
    Customer update(Customer customer);
}
