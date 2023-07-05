package com.farhad.example.springrest.basic.restful;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
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
public class CustomerRestfulCuntroller {
  
    private final CustomerRepository repository;
    private final CustomerModelAssembler assembler;

    @GetMapping("/v2/customers")
    CollectionModel<EntityModel<Customer>> all() {

        List<Customer> customerList = StreamSupport
                    .stream(repository
                                .findAll()
                                .spliterator(),false)
                    .collect(toList());
        List<EntityModel<Customer>>  customers = customerList.stream()
                                                    .map(assembler::toModel)
                                                    .collect(toList());
        return CollectionModel.of(customers, linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withSelfRel());

        // List<EntityModel<Customer>>  customers = customerList.stream()
        //                                             .map(customer -> EntityModel.of(
        //                                                 customer,
        //                                                 linkTo(methodOn(CustomerRestfulCuntroller.class).byId(customer.getId())).withSelfRel(),
        //                                                 linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withRel("customers"))   
        //                                             )
        //                                             .collect(toList());
        // return CollectionModel.of(customers, linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withSelfRel());
    }

    @PostMapping("/v2/customers")
    public ResponseEntity<?> newCustomer(@RequestBody Customer newCustomer) {
        EntityModel<Customer> entityModel = assembler.toModel(repository.save(newCustomer));
        return ResponseEntity
                    .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                    .body(entityModel);
    }

    @GetMapping("/v2/customers/{id}")
    public EntityModel<Customer> byId(@PathVariable Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return assembler.toModel(customer);
        // return EntityModel.of(
        //     customer,
        //     linkTo(methodOn(CustomerRestfulCuntroller.class).byId(id)).withSelfRel(),
        //     linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withRel("customers")
        // );
    }

    @PutMapping("/v2/customers/{id}")
    public ResponseEntity<?> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        Customer updatedCustomer =  repository.findById(id)
                    .map(customer -> {
                        customer.setFirstName(newCustomer.getFirstName());
                        customer.setLastName(newCustomer.getLastName());
                        return repository.save(customer);
                    })
                    .orElseGet(() -> {
                        newCustomer.setId(id);
                        return repository.save(newCustomer);
                    });
        EntityModel<Customer> entityModel = assembler.toModel(updatedCustomer);
        return ResponseEntity
                    .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                    .body(entityModel);
                    
    }

    // This returns an HTTP 204 No Content response.
    @DeleteMapping("/v2/customers/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // @DeleteMapping("/v2/customers/{id}")
    // public void deleteById(@PathVariable Long id) {
    //     repository.deleteById(id);
    // }

}
