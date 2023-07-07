package com.farhad.example.springdatajpa.domailmodel;

import java.time.LocalDate;

import org.javamoney.moneta.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.farhad.example.springdatajpa.domailmodel.dao.impl.CustomerDaoImpl;
import com.farhad.example.springdatajpa.domailmodel.repository.CustomerRepository;
import com.farhad.example.springdatajpa.domailmodel.repository.ProductRepository;

public class App {
    
    @Bean
    public CommandLineRunner init(CustomerRepository customerRepository, ProductRepository productRepository) {
        return args -> {
            Customer tom = Customer.builder()
                                .name("Tom")
                                .money(Money.of(30, "USD"))
                                .repository(customerRepository)
                                .customerDao(new CustomerDaoImpl())
                                .build();
            tom.save();

            Product eggs = Product.builder()
                                .name("Eggs")
                                .price(Money.of(10.00, "USD"))
                                .expirationDate(LocalDate.now().plusDays(7))
                                .repository(productRepository)
                                .build();
            Product butter = Product.builder()
                                .name("Butter")
                                .price(Money.of(20.00, "USD"))
                                .expirationDate(LocalDate.now().plusDays(9))
                                .repository(productRepository)
                                .build();
            Product chesse = Product.builder()
                                .name("Cheese")
                                .price(Money.of(25.00, "USD"))
                                .expirationDate(LocalDate.now().plusDays(2))
                                .repository(productRepository)
                                .build();
            eggs.save();
            butter.save();
            chesse.save();

        };
    }
    public static void main(String[] args) {
        
    }
}
