package com.farhad.example.storedemo.store_details.postgres;

import java.util.List;

import com.farhad.example.storedemo.store_core.orders.Order;
import com.farhad.example.storedemo.store_core.orders.OrderRepository;
import com.farhad.example.storedemo.store_core.security.PrincipalUser;

public class H2OrderRepository implements OrderRepository {

	@Override
	public void submitOrder(Order order) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'submitOrder'");
	}

	@Override
	public List<Order> listOrdersForUser(PrincipalUser user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listOrdersForUser'");
	}

	@Override
	public void removeAllOrders() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeAllOrders'");
	}
	
}
