package com.farhad.example.dddorderdemo.bookstore.domain.model.order;

import java.util.Map;

import com.farhad.example.dddorderdemo.bookstore.domain.model.book.Book;
import com.farhad.example.dddorderdemo.bookstore.domain.model.user.User;

public class OrderFactory {
	public static Order createOrder(User user, Map<Book, Integer> books) {
		Order order = new Order(user);
		for (Map.Entry<Book, Integer>  entry : books.entrySet()) {
			OrderLine orderLine = new OrderLine(entry.getKey(), entry.getValue());
			order.addOrderLine(orderLine);
		}
		return order;
	}
}
