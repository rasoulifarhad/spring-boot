package com.farhad.example.springrest.basic.rest;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springrest.basic.model.Customer;
import com.farhad.example.springrest.basic.model.CustomerNotFoundException;
import com.farhad.example.springrest.basic.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CustomerCuntroller {
  
    private final CustomerRepository repository;

    @GetMapping("/customers")
    List<Customer> all() {

        return  StreamSupport
                    .stream(repository
                                .findAll()
                                .spliterator(),false)
                    .collect(toList());
    }

    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer byId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return repository.findById(id)
                    .map(customer -> {
                        customer.setFirstName(newCustomer.getFirstName());
                        customer.setLastName(newCustomer.getLastName());
                        return repository.save(customer);
                    })
                    .orElseGet(() -> {
                        newCustomer.setId(id);
                        return repository.save(newCustomer);
                    });
    }

    @DeleteMapping("/customers/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
