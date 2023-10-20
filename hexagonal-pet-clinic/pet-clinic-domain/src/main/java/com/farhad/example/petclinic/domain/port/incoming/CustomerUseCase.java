package com.farhad.example.petclinic.domain.port.incoming;

import java.util.List;

import com.farhad.example.petclinic.domain.model.customer.Customer;

public interface CustomerUseCase {


    Customer get(long id);

    List<Customer> getAll();

    void add(Customer customer);
}
