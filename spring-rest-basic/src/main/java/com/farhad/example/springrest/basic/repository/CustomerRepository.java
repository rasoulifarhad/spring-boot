package com.farhad.example.springrest.basic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.springrest.basic.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
    List<Customer> findByLastName(String lastName);
}
