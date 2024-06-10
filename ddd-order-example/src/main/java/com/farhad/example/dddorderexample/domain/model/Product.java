package com.farhad.example.dddorderexample.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Product {

    private ProductId id;
    private String description;
    private BigDecimal price;
    private BigDecimal total;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ProductId implements Serializable {

        @Getter
        private String value;

        public static ProductId of(String value) {
            return new ProductId(value);
        }

    }
}
