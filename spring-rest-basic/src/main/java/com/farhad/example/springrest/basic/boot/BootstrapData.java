package com.farhad.example.springrest.basic.boot;

import static com.farhad.example.springrest.basic.model.Status.COMPLETED;
import static com.farhad.example.springrest.basic.model.Status.IN_PROGRESS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springrest.basic.model.Customer;
import com.farhad.example.springrest.basic.model.Order;
import com.farhad.example.springrest.basic.repository.CustomerRepository;
import com.farhad.example.springrest.basic.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;

@Slf4j
@Configuration
public class BootstrapData {
    
    @Bean
    public CommandLineRunner initData(CustomerRepository customerRepository, 
                                        OrderRepository orderRepository) {
        Faker faker = new Faker();
        Name name = faker.name();
        return args -> {
            log.info("");
            // repository.save(new Customer("Ali hamidi" ));
            // repository.save(new Customer("hamid hamidi" ));
            // repository.save(new Customer(name.firstName() + " " +  name.lastName() ));
            // repository.save( new Customer(name.firstName() + " " +  name.lastName()));
            // repository.save( new Customer(name.firstName() + " " +  name.lastName()));
            // repository.save( new Customer(name.firstName() + " " +  name.lastName()));

            customerRepository.save(new Customer("Ali", "hamidi" ));
            customerRepository.save(new Customer("hamid", "hamidi" ));
            customerRepository.save(new Customer(name.firstName(), name.lastName() ));
            customerRepository.save( new Customer(name.firstName(), name.lastName()));
            customerRepository.save( new Customer(name.firstName(), name.lastName()));

            log.info("All Customers");
            for(Customer customer : customerRepository.findAll()) {
                log.info("Pre loaded customer: {}", customer);
            }

            log.info("");

            log.info("Customer with lastName(hamidi) ");
            customerRepository.findByLastName("hamidi").forEach(c -> log.info("{}", c) );

            orderRepository.save(new Order(faker.commerce().productName(), IN_PROGRESS));
            orderRepository.save(new Order(faker.commerce().productName(), COMPLETED));

            orderRepository.findAll().forEach(order -> log.info("Pre loaded order: {}", order));
            


        };
    }
}
