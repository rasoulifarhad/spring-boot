package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import static com.farhad.example.coffeeorder.application.order.OrderTestFactory.anOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;

@RestResourceTest
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Orders orders;

	private final String creditCardJson = 
		"{" +
				"\"cardHolderName\": \"Test\"," +
				"\"cardNumber\": \"123456\"," +
				"\"expiryMonth\": 12," +
				"\"expiryYear\": 2023" +
		"}"  
		;

	@Test
	public void payOrder() throws Exception {
		Order order = orders.save(anOrder());

		mockMvc.perform(put("/payment/{id}", order.getId())
									.contentType(MediaType.APPLICATION_JSON_VALUE)
									.content(creditCardJson))
				.andExpect(status().isOk());
	}
}
