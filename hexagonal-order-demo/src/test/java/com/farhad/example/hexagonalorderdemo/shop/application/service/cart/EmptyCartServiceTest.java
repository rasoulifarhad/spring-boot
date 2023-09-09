package com.farhad.example.hexagonalorderdemo.shop.application.service.cart;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public class EmptyCartServiceTest {

	private static final CustomerId TEST_CUSTOMER_ID = new CustomerId(12345);

	private CartRepository cartRepository = mock(CartRepository.class);
	private EmptyCardService emptyCartService = new EmptyCardService(cartRepository);

	@Test
	public void given_when_emptyCart_then_invokesDeleteOnThePresistencePort() {

		//given
		//when
		emptyCartService.emptyCart(TEST_CUSTOMER_ID);
		//then
		verify(cartRepository).deleteById(TEST_CUSTOMER_ID);
	}
}
