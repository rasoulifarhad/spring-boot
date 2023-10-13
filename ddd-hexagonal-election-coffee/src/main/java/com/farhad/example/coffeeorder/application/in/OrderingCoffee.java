package com.farhad.example.coffeeorder.application.in;

import java.util.UUID;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.payment.CreditCard;
import com.farhad.example.coffeeorder.application.payment.Payment;
import com.farhad.example.coffeeorder.application.payment.Receipt;

public interface OrderingCoffee {
	Order placeOrder(Order order);
	Order updateOrder(UUID orderId, Order order);
	void cancelOrder(UUID orderId);
	Payment payOrder(UUID orderId, CreditCard creditCard);
	Receipt readReceipt(UUID orderId);

	Order takeOrder(UUID orderId);
}
