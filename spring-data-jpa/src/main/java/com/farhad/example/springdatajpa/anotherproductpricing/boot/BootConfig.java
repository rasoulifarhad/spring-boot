package com.farhad.example.springdatajpa.anotherproductpricing.boot;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.anotherproductpricing.model.PricingType;
import com.farhad.example.springdatajpa.anotherproductpricing.model.Product;
import com.farhad.example.springdatajpa.anotherproductpricing.model.ProductPricing;
import com.farhad.example.springdatajpa.anotherproductpricing.repository.ProductPricingRepository;
import com.farhad.example.springdatajpa.anotherproductpricing.repository.ProductRepository;

@Configuration
public class BootConfig {
    
    @Bean
    public CommandLineRunner boot(ProductRepository productRepository, ProductPricingRepository productPricingRepository) {
        return args -> {
             Product p = Product.builder()
                                .id(1L)
                                .name("Hypersistence Optimizer")
                                .build();
            p.addPricingPlan(
                ProductPricing.builder()
                    .name("Individual License")
                    .type(PricingType.SUBSCRIPTION)
                    .price(Money.of(new BigDecimal("49.0"), "USD"))
                    .build()
            );
            p.addPricingPlan(
                ProductPricing.builder()
                    .name("5-Year Individual License")
                    .type(PricingType.ONE_TIME_PURCHASE)
                    .price(Money.of(new BigDecimal("199.0"), "USD"))
                    .build()
            );
            p.addPricingPlan(
                ProductPricing.builder()
                    .name("10-Dev Group License")
                    .type(PricingType.SUBSCRIPTION)
                    .price(Money.of(new BigDecimal("349.0"), "USD"))
                    .build()
            );

            productRepository.save(p);


            productRepository.findAll().forEach(product -> System.out.println(product));

        };
    }
}
