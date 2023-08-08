package com.farhad.example.auditingdemo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Boot {
    
    @Bean
    public CommandLineRunner runner(CustomerRepository customerRepository) {
        return args ->  {

            // create and save customr
            Customer farhad = Customer.builder()
                                    .firstName("farhad")
                                    .lastName("rasouli")
                                    .build();
            Customer createdFarhad = customerRepository.save(farhad);

            // search customer by id
            Optional<Customer> searchedFarhad = customerRepository.findById(createdFarhad.getId());
            System.out.println(searchedFarhad);

            // update customer
            Customer ct = searchedFarhad.get();
            ct.setLastName("rasouli_02");
            customerRepository.save(ct);

            // search updated document
            Customer updatedCustomer = customerRepository.findById(createdFarhad.getId()).get();
            System.out.println(updatedCustomer);


        };
    }
}
