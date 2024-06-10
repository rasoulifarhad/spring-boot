package com.farhad.example.dddorderexample.domain.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.shared.BaseAggregateRoot;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
public class Order extends BaseAggregateRoot<OrderId> {

    // private OrderId id;
    private String CustomerId;
    private String orderNo;
    private Instant orderDate;
    private Status status;
    private Set<LineItem> lineItems;
    private ShippingAddress shippingAddress;
    private MonetaryValue monetaryValue;

    public enum Status {

    }

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class OrderId implements Serializable {

        @Getter
        private String value;

        public static OrderId of(String value) {
            return new OrderId(value);
        }

    }

}
