package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import static com.farhad.example.coffeeorder.application.order.OrderTestFactory.aReadyOrder;
import static com.farhad.example.coffeeorder.application.order.OrderTestFactory.anOrder;
import static com.farhad.example.coffeeorder.application.payment.PaymentTestFactory.aPaymentForOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.application.out.Payments;

@RestResourceTest
public class ReceiptControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Orders orders;

	@Autowired
	private Payments payments;

	@Test
	public void readReceipt() throws Exception {
		Order order = orders.save(anOrder());
		payments.save(aPaymentForOrder(order));

		mockMvc.perform(get("/receipt/{id}", order.getId()))
				.andExpect(status().isOk());
	}

	@Test
	void completeOrder() throws Exception {
		Order order = orders.save(aReadyOrder());

		mockMvc.perform(delete("/receipt/{id}", order.getId()))
				.andExpect(status().isOk());
	}
}
