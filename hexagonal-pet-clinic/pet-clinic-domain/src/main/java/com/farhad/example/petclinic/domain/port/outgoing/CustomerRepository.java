package com.farhad.example.petclinic.domain.port.outgoing;

import java.util.List;

import com.farhad.example.petclinic.domain.model.customer.Customer;

public interface CustomerRepository {
    List<Customer> getAll();

    Customer get(Long id);

    void add(Customer customer);	
}
