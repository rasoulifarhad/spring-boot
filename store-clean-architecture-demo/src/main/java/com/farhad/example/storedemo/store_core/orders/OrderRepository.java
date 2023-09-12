package com.farhad.example.storedemo.store_core.orders;

import java.util.List;

import com.farhad.example.storedemo.store_core.security.PrincipalUser;

public interface OrderRepository {
	void submitOrder(Order order);
	List<Order> listOrdersForUser(PrincipalUser user);
	void removeAllOrders();

}
