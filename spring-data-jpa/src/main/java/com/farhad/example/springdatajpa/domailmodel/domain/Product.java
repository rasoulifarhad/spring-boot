package com.farhad.example.springdatajpa.domailmodel.domain;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.javamoney.moneta.Money;

import com.farhad.example.springdatajpa.domailmodel.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "products")
public class Product {

    private static final int DAYS_UNTILEXPIRATION_WHEN_DISCOUNT_ACTIVE = 4;
    private static final double DISCOUNT_RATE = 0.2;

    @NonNull private final ProductRepository repository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull private String name;
    @NonNull private MonetaryAmount price;
    @NonNull private LocalDate expirationDate;

    public void save() {
        Optional<Product> product = repository.findByName(name);
        if (product.isPresent()) {
            this.id = product.get().id;
            repository.save(this);
        } else {
            repository.save(this);
        }
    }

    public MonetaryAmount getSalePrice() {
        return price.subtract(calculateDiscount());
    }

    private MonetaryAmount calculateDiscount() {
        if (ChronoUnit.DAYS.between(LocalDate.now(), expirationDate) < DAYS_UNTILEXPIRATION_WHEN_DISCOUNT_ACTIVE ) {
            return price.multiply(DISCOUNT_RATE);
        }
        return Money.zero(Monetary.getCurrency("USD"));
    }
}
