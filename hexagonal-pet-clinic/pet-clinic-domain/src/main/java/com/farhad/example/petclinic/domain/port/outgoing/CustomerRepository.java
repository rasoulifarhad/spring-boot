package com.farhad.example.petclinic.domain.port.outgoing;

import java.util.List;
import java.util.Optional;

import com.farhad.example.petclinic.domain.model.customer.Customer;

public interface CustomerRepository {
    List<Customer> getAll();

    Optional<Customer> get(Long id);

    void add(Customer customer);	
}
