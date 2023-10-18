package com.farhad.example.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.farhad.example.shopping.api.ShoppingListService;

@SpringBootApplication
public class MockRestApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(MockRestApplication.class, args);
	}

	@MockBean
	private ShoppingListService shoppingListService;
}
