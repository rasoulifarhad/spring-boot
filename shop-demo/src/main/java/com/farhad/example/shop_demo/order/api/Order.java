package com.farhad.example.shop_demo.order.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Order {
    
    private final OrderId orderId;
    private final Long userId;
    private final List<OrderItem> items;
    private final LocalDateTime orderDate;
    
    public Order(OrderId orderId, Long userId, List<OrderItem> items, LocalDateTime orderDate) {
        this.orderId = Objects.requireNonNull(orderId);
        this.userId = Objects.requireNonNull(userId);
        this.items = Objects.requireNonNull(items);
        this.orderDate = Objects.requireNonNull(orderDate);
    }   
    
    public static Order createNew(List<OrderItem> items, long userId) {
        return new Order(OrderId.NONE, userId, items, LocalDateTime.now());
    }

    public static Order reconstitute(OrderId id, long userId, List<OrderItem> items) {
        return new Order(id, userId, items, LocalDateTime.now());
    }    
}
