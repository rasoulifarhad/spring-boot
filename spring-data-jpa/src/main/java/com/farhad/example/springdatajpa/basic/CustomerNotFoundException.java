package com.farhad.example.springdatajpa.basic;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Customer not found: " + id);
    }
}
