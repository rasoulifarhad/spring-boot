package com.farhad.example.springdatajpa.domailmodel.domain;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;
import org.javamoney.moneta.Money;

import com.farhad.example.springdatajpa.domailmodel.repository.ProductRepository;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
@TypeDef(
    typeClass = MonetaryAmountType.class,
    defaultForType = MonetaryAmount.class
)
public class Product {

    private static final int DAYS_UNTILEXPIRATION_WHEN_DISCOUNT_ACTIVE = 4;
    private static final double DISCOUNT_RATE = 0.2;

    @NonNull 
    @Transient
    private ProductRepository repository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull 
    private String name;

    @NonNull 
    @Columns( columns = {
        @Column(name = "price_amount"),
        @Column(name = "price_currency")
    })
    private MonetaryAmount price;
    @NonNull 
    private LocalDate expirationDate;

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
