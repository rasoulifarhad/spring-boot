package com.farhad.example.springdatajpa.domailmodel.boot;

import java.time.LocalDate;

import org.javamoney.moneta.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.domailmodel.domain.Customer;
import com.farhad.example.springdatajpa.domailmodel.domain.Product;
import com.farhad.example.springdatajpa.domailmodel.repository.CustomerRepository;
import com.farhad.example.springdatajpa.domailmodel.repository.ProductRepository;

@Configuration
public class BootRunner {
    
    @Bean
    public CommandLineRunner runner(ProductRepository productRepository, CustomerRepository customerRepository) {
        return  args -> {
            Customer tom = Customer.builder()
                                .name("Tom")
                                .money(Money.of(30, "USD"))
                                .repository(customerRepository)
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

            tom.showBalance();
            tom.showPurchases();

            tom.buyProduct(eggs);
            tom.showBalance();

            tom.buyProduct(butter);
            tom.showBalance();

            // Trying to buy cheese, but receive a refusal
            // because he didn't have enough money
            tom.buyProduct(chesse);
            tom.showBalance();    

            tom.save();

            tom.showBalance();
            tom.showPurchases();
        } ;
    }
}
