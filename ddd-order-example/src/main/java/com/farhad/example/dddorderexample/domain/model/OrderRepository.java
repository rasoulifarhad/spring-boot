package com.farhad.example.dddorderexample.domain.model;

import java.util.Collection;

public interface OrderRepository {

    void saveOrder(Order order);
    Order findByOrderId(String orderId);
    Collection<Order> findAllOrders();

}
