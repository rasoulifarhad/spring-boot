package com.farhad.example.shop_demo.order.internal.database.api;

import com.farhad.example.shop_demo.order.api.Order;

public interface OrderDatabase {
    Order saveOrder(Order order);
}
