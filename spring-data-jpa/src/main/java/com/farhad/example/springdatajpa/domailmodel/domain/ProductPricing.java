package com.farhad.example.springdatajpa.domailmodel.domain;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import org.hibernate.annotations.Columns;

import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import lombok.Data;

@Entity
@Table(name = "product_pricing")
@TypeDef(
    typeClass = MonetaryAmountType.class,
    defaultForType = MonetaryAmount.class
)
@Data
public class ProductPricing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String name;

    @Enumerated
    private PricingType type;

    @Columns(columns = {
        @Column(name = "price_amont"),
        @Column(name = "price_currency")
    })
    private MonetaryAmount price;

}
