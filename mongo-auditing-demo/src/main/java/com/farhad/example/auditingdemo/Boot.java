package com.farhad.example.auditingdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Boot {
    
    @Bean
    public CommandLineRunner runner(CustomerWoVRepository repository) {
        return args ->  {

            // create and save customr
            CustomerWoV farhad = CustomerWoV.builder()
                                    .name("farhad")
                                    .build();
            CustomerWoV createdEntity01 = repository.save(farhad);
            System.out.println();
            System.out.println("Given entity, When id is null and save entity, then :");
            System.out.println(createdEntity01);

            // // search customer by id
            // System.out.println();
            // System.out.println("Given entity persistet in repository, When we search by id, then :");
            // Optional<CustomerWoV> searchedEntity = repository.findById(createdEntity01.getId());
            // System.out.println(searchedEntity);

            // // update customer
            // System.out.println();
            // System.out.println("Given entity persistet in repository, When we update entity, then :");
            // CustomerWoV ct = searchedEntity.get();
            // ct.setName("rasouli_02");
            // CustomerWoV updatedEntity01 = repository.save(ct);
            // System.out.println(updatedEntity01); 

            // // search updated document
            // System.out.println();
            // System.out.println("Given entity persistet in repository, When we update entity and search entity with id, then :");
            // updatedEntity01.setName("updated farhad");
            // repository.save(updatedEntity01);
            // searchedEntity = repository.findById(createdEntity01.getId());
            // System.out.println(searchedEntity.get());

            // Create , set Id field , and save
            CustomerWoV farhadWithIdSeted = CustomerWoV.builder()
                                                            .id("blahblahblah")
                                                            .name("Id seted")
                                                            .build();
            CustomerWoV createdEntity02 = repository.save(farhadWithIdSeted);
            System.out.println();
            System.out.println("Given entity, When we set id and save entity, then :");
            System.out.println(createdEntity02);



        };
    }
}
