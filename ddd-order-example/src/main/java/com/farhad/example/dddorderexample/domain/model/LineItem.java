package com.farhad.example.dddorderexample.domain.model;

import com.farhad.example.dddorderexample.domain.shared.ValueObject;

import lombok.Value;

public class LineItem {

    private LineItemId id;
    private Integer quantity;
    private Product product;

   @Value
    public static class  LineItemId implements ValueObject<LineItemId> {

        private String value;

        @Override
        public boolean sameValueAs(LineItemId other) {
            return this.equals(other);
        }

        public static LineItemId of(String value) {
            return new LineItemId(value);
        }
    
        
    }    
}
