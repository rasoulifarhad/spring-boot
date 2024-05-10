package com.farhad.example.dddorderexample.domain.model;

import java.math.BigDecimal;

import com.farhad.example.dddorderexample.domain.shared.ValueObject;

import lombok.Value;

public class Product {

    private ProductId id;
    private String description;
    private BigDecimal price;
    private BigDecimal total;

   @Value
    public static class  ProductId implements ValueObject<ProductId> {

        private String value;

        @Override
        public boolean sameValueAs(ProductId other) {
            return this.equals(other);
        }

        public static ProductId of(String value) {
            return new ProductId(value);
        }
    
        
    }    
}
