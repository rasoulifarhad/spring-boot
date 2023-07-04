package com.farhad.example.springdatajpa.basic.boot;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.basic.model.Customer;
import com.farhad.example.springdatajpa.basic.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;

@Slf4j
@Configuration
public class BootstrapData {
    
    @Bean
    public CommandLineRunner initData(CustomerRepository repository) {
        Faker faker = new Faker();
        Name name = faker.name();
        return args -> {
            log.info("");
            repository.save(new Customer("Ali", "hamidi" ));
            repository.save(new Customer("hamid", "hamidi" ));
            repository.save(new Customer(name.firstName(), name.lastName() ));
            repository.save( new Customer(name.firstName(), name.lastName()));
            repository.save( new Customer(name.firstName(), name.lastName()));
            repository.save( new Customer(name.firstName(), name.lastName()));

            log.info("All Customers");
            for(Customer customer : repository.findAll()) {
                log.info("{}", customer);
            }

            log.info("");
            Optional<Customer> customer = repository.findById(1L);
            log.info("Customrer with id(1): {} ", customer.get());
            log.info("");

            log.info("Customer with lastName(hamidi) ");
            repository.findByLastName("hamidi").forEach(c -> log.info("{}", c) );

        };
    }
}
