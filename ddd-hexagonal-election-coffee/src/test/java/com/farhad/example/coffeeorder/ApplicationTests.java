package com.farhad.example.coffeeorder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.farhad.example.coffeeorder.application.CoffeeMachine;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CoffeeMachine coffeeMachine;

	@Test
	void contextLoads() {
	}

	@Test
	public void processNewOrder() throws Exception{
			UUID orderId = placeOrder();
		payOrder(orderId);
		prepareOrder(orderId);
		readReceipt(orderId);
		takeOrder(orderId);
	}

    @Test
    void cancelOrderBeforePayment() throws Exception {
        UUID orderId = placeOrder();
        cancelOrder(orderId);
    }
	
    private void cancelOrder(UUID orderId) throws Exception {
        mockMvc.perform(delete("/order/{id}", orderId))
                .andExpect(status().isNoContent());
    }

	private void takeOrder(UUID orderId) throws Exception {
		mockMvc.perform(delete("/receipt/{id}", orderId))
					.andExpect(status().isOk());		
	}

	private void readReceipt(UUID orderId) throws Exception {
		mockMvc.perform(get("/receipt/{id}", orderId))
				.andExpect(status().isOk());
		
	}

	private void prepareOrder(UUID orderId) {
		coffeeMachine.startPreparingOrder(orderId);
		coffeeMachine.finishPreparingOrder(orderId);
	}

	private void payOrder(UUID orderId) throws Exception {
		mockMvc.perform(put("/payment/{id}", orderId)
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.content(
								"{" +
									"\"cardHolderName\": \"Test\"," +
									"\"cardNumber\": \"123456\"," +
									"\"expiryMonth\": 12," +
									"\"expiryYear\": 2023" +
								"}"  
							))
				.andExpect(status().isOk());	
	}

	private UUID placeOrder() throws Exception {
		String location = mockMvc.perform(post("/order")
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.content(
								"{" +
									"\"location\": \"IN_STORE\"," +
									"\"items\": [{" +
										"\"drink\": \"LATTE\"," +
										"\"quantity\": 1," +
										"\"milk\": \"WHOLE\"," +
										"\"size\": \"LARGE\"" +
									"]}" +
								"}"  
							))
				.andExpect(status().isCreated())
				.andReturn()
				.getResponse()
				.getHeader(HttpHeaders.LOCATION);
		return location == null ? null : UUID.fromString(location.substring(location.lastIndexOf("/") + 1));
	}

	

}
