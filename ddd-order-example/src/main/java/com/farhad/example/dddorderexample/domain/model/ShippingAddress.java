package com.farhad.example.dddorderexample.domain.model;

import java.io.Serializable;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.model.ShippingAddress.ShippingAddressId;
import com.farhad.example.dddorderexample.domain.shared.BaseAggregateRoot;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity

public class ShippingAddress extends BaseAggregateRoot<ShippingAddressId> {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String label;
    private OrderId orderId;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ShippingAddressId implements Serializable {

        @Getter
        private String value;

        public static ShippingAddressId of(String value) {
            return new ShippingAddressId(value);
        }

    }

    // public static ShippingAddress from(ShippingAddressDto shippingAddressDto) {
    // return ShippingAddress.builder().
    // }
}
