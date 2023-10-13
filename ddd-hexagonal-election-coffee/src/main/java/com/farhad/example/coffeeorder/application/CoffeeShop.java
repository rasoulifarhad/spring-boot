package com.farhad.example.coffeeorder.application;

import java.time.LocalDate;
import java.util.UUID;

import com.farhad.example.coffeeorder.application.in.OrderingCoffee;
import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.payment.CreditCard;
import com.farhad.example.coffeeorder.application.payment.Payment;
import com.farhad.example.coffeeorder.application.payment.Receipt;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	
public class CoffeeShop implements OrderingCoffee {

	private final Orders orders;
	private final Payments payments;

	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'placeOrder'");
	}

	@Override
	public Order updateOrder(UUID orderId, Order order) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
	}

	@Override
	public void cancelOrder(UUID orderId) {

	}

	@Override
	public Payment payOrder(UUID orderId, CreditCard creditCard) {
		Order order = orders.findByOrderId(orderId);
		orders.save(order.markPaid());
		return payments.save(new Payment(orderId, creditCard, LocalDate.now()));
	}

	@Override
	public Receipt readReceipt(UUID orderId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'readReceipt'");
	}

	@Override
	public Order takeOrder(UUID orderId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'takeOrder'");
	}
	

}
