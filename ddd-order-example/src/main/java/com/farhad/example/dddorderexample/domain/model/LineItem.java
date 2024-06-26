package com.farhad.example.dddorderexample.domain.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LineItem {

    private LineItemId id;
    private Integer quantity;
    private Product product;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class LineItemId implements Serializable {

        @Getter
        private String value;

        public static LineItemId of(String value) {
            return new LineItemId(value);
        }

    }
}
