package com.farhad.example.auditingdemo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String> {
    
    public List<Customer> findByLastName(String lastName);

}
