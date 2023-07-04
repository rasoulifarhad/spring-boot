package com.farhad.example.springdatajpa.basic.restful;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.farhad.example.springdatajpa.basic.model.Customer;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer customer) {
        return EntityModel.of(
            customer,
            linkTo(methodOn(CustomerRestfulCuntroller.class).byId(customer.getId())).withSelfRel(),
            linkTo(methodOn(CustomerRestfulCuntroller.class).all()).withRel("customers"));
    }
    
}
