package com.farhad.example.dddorderexample.domain.model;

import java.time.Instant;
import java.util.Set;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.shared.BaseAggregateRoot;
import com.farhad.example.dddorderexample.domain.shared.ValueObject;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Value;

@Getter
@Entity
public class Order extends BaseAggregateRoot<OrderId>{

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

    @Value
    public static class  OrderId implements ValueObject<OrderId> {

        private String value;

        @Override
        public boolean sameValueAs(OrderId other) {
            return this.equals(other);
        }

        public static OrderId of(String value) {
            return new OrderId(value);
        }
    
        
    }

}
