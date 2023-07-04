package com.farhad.example.springdatajpa.basic.restful;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springdatajpa.basic.CustomerNotFoundException;
import com.farhad.example.springdatajpa.basic.model.Customer;
import com.farhad.example.springdatajpa.basic.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CustomerRestfulCuntroller {
  
    private final CustomerRepository repository;

    @GetMapping("/restful/customers")
    CollectionModel<EntityModel<Customer>> all() {

        List<Customer> customerList = StreamSupport
                    .stream(repository
                                .findAll()
                                .spliterator(),false)
                    .collect(toList());
        List<EntityModel<Customer>>  customers = customerList.stream()
                                                    .map(customer -> EntityModel.of(
                                                        customer,
                                                        linkTo(methodOn(CustomerRestfulCuntroller.class).byId(customer.getId())).withSelfRel(),
                                                        linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withRel("customers"))   
                                                    )
                                                    .collect(toList());
        return CollectionModel.of(customers, linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withSelfRel());
    }

    @PostMapping("/restful/customers")
    public Customer newCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @GetMapping("/restful/customers/{id}")
    public EntityModel<Customer> byId(@PathVariable Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return EntityModel.of(
            customer,
            linkTo(methodOn(CustomerRestfulCuntroller.class).byId(id)).withSelfRel(),
            linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withRel("customers")
        );
    }

    @PutMapping("/restful/customers/{id}")
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

    @DeleteMapping("/restful/customers/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
