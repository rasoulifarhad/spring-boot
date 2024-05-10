package com.farhad.example.dddorderexample.domain.model;

import com.farhad.example.dddorderexample.domain.shared.ValueObject;

import lombok.Value;

public class ShippingAddress {

    private ShippingAddressId id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String label;
    
  @Value
    public static class  ShippingAddressId implements ValueObject<ShippingAddressId> {

        private String value;

        @Override
        public boolean sameValueAs(ShippingAddressId other) {
            return this.equals(other);
        }

        public static ShippingAddressId of(String value) {
            return new ShippingAddressId(value);
        }
    
        
    } 
}
