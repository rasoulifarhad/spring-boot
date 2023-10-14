package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import static com.farhad.example.coffeeorder.application.order.OrderTestFactory.anOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.infrastructure.config.DomainConfigTest;

@WebMvcTest
@Import(DomainConfigTest.class)
public class OrderControllerTest {

	@Autowired 
	private MockMvc mockMvc;

	@Autowired 
	private Orders orders;

	private final String orderJson = 
		"{" +
			"\"location\": \"IN_STORE\"," +
			"\"items\": [{" +
				"\"drink\": \"LATTE\"," +
				"\"quantity\": 1," +
				"\"milk\": \"WHOLE\"," +
				"\"size\": \"LARGE\"" +
		"	}]"  +
		"}"  
		;

	@Test
	public void createOrder() throws Exception {
		mockMvc.perform(post("/order", null)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(orderJson))
				.andExpect(status().isCreated());
	}

	@Test
	public void updateOrder() throws Exception {
		Order order = orders.save(anOrder());

		mockMvc.perform(post("/order/{id}", order.getId())
												.contextPath(MediaType.APPLICATION_JSON_VALUE)
												.content(orderJson))
				.andExpect(status().isOk());
	}

	@Test
	public void cancelOrder() throws Exception {
		Order order = orders.save(anOrder());

		mockMvc.perform(delete("/order/{id}", order.getId()))
				.andExpect(status().isNoContent());
					
	}

}
