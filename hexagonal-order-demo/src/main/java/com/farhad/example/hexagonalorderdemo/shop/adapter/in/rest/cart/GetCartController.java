package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.cart;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.GetCartUseCase;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class GetCartController {
	

	private final GetCartUseCase getCartUseCase;

	@GetMapping("/{customerId}")
	public CartDto getCart(@PathVariable("customerId") String customerIdString ) {
		CustomerId customerId = parseCustomerId(customerIdString);
		Cart cart = getCartUseCase.getCart(customerId);
		return CartDto.fromDomainModel(cart);
	}

	private CustomerId parseCustomerId(String customerIdString) {
		try {
			return new CustomerId(Integer.parseInt(customerIdString));
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid 'customerId'");
		}
	}

}
