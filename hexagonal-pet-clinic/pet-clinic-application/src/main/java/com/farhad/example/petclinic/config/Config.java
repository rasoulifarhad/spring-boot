package com.farhad.example.petclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.petclinic.application.customer.CustomerService;
import com.farhad.example.petclinic.application.pet.PetService;
import com.farhad.example.petclinic.domain.port.outgoing.CustomerRepository;
import com.farhad.example.petclinic.domain.port.outgoing.PetRepository;
import com.farhad.example.petclinic.infrastructure.adapter.out.persistance.inmemory.InMemoryCustomerRepsitory;
import com.farhad.example.petclinic.infrastructure.adapter.out.persistance.inmemory.InMemoryPetRepsitory;

@Configuration
public class Config {

	    @Bean
    public PetRepository petRepository() {
        return new InMemoryPetRepsitory();
    }

    @Bean
    public PetService petService(PetRepository petRepository) {
        return new PetService(petRepository);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new InMemoryCustomerRepsitory();
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository, PetService petService) {
        return new CustomerService(customerRepository, petService);
    }

}
