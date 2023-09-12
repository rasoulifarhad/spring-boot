package com.farhad.example.dddorderdemo.bookstore.domain.model.order;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.dddorderdemo.bookstore.domain.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Order {
	private OrderId id;
	private final User user;
	private List<OrderLine> orderLines = new ArrayList<>(); ;

	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
}
