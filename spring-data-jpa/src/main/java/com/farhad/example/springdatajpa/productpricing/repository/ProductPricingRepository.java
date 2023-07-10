package com.farhad.example.springdatajpa.productpricing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.productpricing.model.ProductPricing;

public interface ProductPricingRepository extends JpaRepository<ProductPricing, Long> {
    
}
