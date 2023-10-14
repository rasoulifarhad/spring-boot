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
		return orders.save(order);
	}

	@Override
	public Order updateOrder(UUID orderId, Order order) {
		Order existingOrder = orders.findByOrderId(orderId);
		return orders.save(existingOrder.update(order));
	}

	@Override
	public void cancelOrder(UUID orderId) {
		Order order = orders.findByOrderId(orderId);
		if (!order.canBeCancelled()) {
			throw new IllegalStateException("Order is already paid");
		}
	}

	@Override
	public Payment payOrder(UUID orderId, CreditCard creditCard) {
		Order order = orders.findByOrderId(orderId);
		orders.save(order.markPaid());
		return payments.save(new Payment(orderId, creditCard, LocalDate.now()));
	}

	@Override
	public Receipt readReceipt(UUID orderId) {
		Order order = orders.findByOrderId(orderId);
		Payment payment = payments.findPaymentByOrderId(orderId);
		return new Receipt(order.getCost(), payment.getPaid());
	}

	@Override
	public Order takeOrder(UUID orderId) {
		Order order = orders.findByOrderId(orderId);

		return orders.save(order.markTaken());
	}
	

}
