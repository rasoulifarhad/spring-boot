package com.farhad.example.springdatajpa.domailmodel.domain;

import javax.money.MonetaryAmount;

import lombok.Data;

// @Entity
// @Table(name = "product_pricing")
// @TypeDef(
//     typeClass = MonetaryAmountType.class,
//     defaultForType = MonetaryAmount.class
// )
@Data
public class ProductPricing {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Product product;

    private String name;

    // @Enumerated
    private PricingType type;

    // @Columns(columns = {
    //     @Column(name = "price_amont"),
    //     @Column(name = "price_currency")
    // })
    private MonetaryAmount price;

}
