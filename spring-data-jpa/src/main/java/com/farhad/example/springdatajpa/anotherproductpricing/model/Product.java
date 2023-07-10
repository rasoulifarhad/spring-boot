package com.farhad.example.springdatajpa.anotherproductpricing.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(
        mappedBy = "product",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @Builder.Default 
    private List<ProductPricing> pricingPlans = new ArrayList<>();

    public Product addPricingPlan(ProductPricing pricingPlan) {
        pricingPlans.add(pricingPlan);
        pricingPlan.setProduct(this);
        return this;
    }

}
