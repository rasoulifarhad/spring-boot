package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.cart;

import static com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.common.CustomerIdParser.parseCustomerId;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.EmptyCartUseCase;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class EmptyCartController {
	

	private final EmptyCartUseCase emptyCartUseCase;

	@DeleteMapping("/customerId")
	public void deleteCart(@PathVariable("customerId") String customerIdString) {
		CustomerId customerId = parseCustomerId(customerIdString);
		emptyCartUseCase.emptyCart(customerId);
	}
}
