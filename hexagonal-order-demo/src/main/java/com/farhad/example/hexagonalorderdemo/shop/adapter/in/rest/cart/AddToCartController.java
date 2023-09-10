package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.cart;

import static com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.common.CustomerIdParser.parseCustomerId;
import static com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.common.ProductIdParser.parseProductId;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.AddToCartUseCase;
import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.ProductNotFoundException;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.NotEnoughItemsInStockException;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class AddToCartController {
	
	private final AddToCartUseCase addToCartUseCase; 

	@PostMapping("/{customerId}/line-items")
	public CartDto addLineItem(
					@PathVariable("customerId")       String customerIdString,
					@RequestParam(name = "productId") String productIdString,
					@RequestParam(name = "quantity")  int quantity) {
		ProductId productId = parseProductId(productIdString);
		CustomerId customerId = parseCustomerId(customerIdString);
		try {
			Cart cart = addToCartUseCase.addToCart(customerId, productId, quantity);
			return CartDto.fromDomainModel(cart);
		} catch (ProductNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The requested product does not exist");
		} catch (NotEnoughItemsInStockException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Only %d items in stock", e.itemsInStock() ));
		}

	}

}
