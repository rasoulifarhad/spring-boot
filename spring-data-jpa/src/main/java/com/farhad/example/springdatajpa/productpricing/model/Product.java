package com.farhad.example.springdatajpa.productpricing.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Table(name = "product" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    // @OneToMany(
    //     mappedBy = "product",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductPricing> pricingPlans;

    public Product addPricingPlan(ProductPricing pricingPlan) {
        pricingPlans.add(pricingPlan);
        pricingPlan.setProduct(this);
        return this;
    }

}
