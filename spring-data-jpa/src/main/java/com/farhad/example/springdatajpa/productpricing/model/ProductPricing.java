package com.farhad.example.springdatajpa.productpricing.model;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.TypeDef;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ProductPricing")
@Table(name = "product_pricing")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(typeClass = MonetaryAmountType.class, defaultForType = MonetaryAmount.class)
public class ProductPricing {
    
    @Id
    // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated
    private PricingType type;

    // @AttributeOverride(
    //     name = "amount",
    //     column = @Column(name =  "price_amount")
    // )
    // @AttributeOverride(
    //     name = "currency",
    //     @Column(name = "price_currency") 
    // )
    // @CompositeType(MonetaryAmountType.class)
    @Columns(columns = {
        @Column(name = "price_amount"),
        @Column(name = "price_currency")
    })
    private MonetaryAmount price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
