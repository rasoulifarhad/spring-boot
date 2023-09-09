package com.farhad.example.hexagonalorderdemo.shop.application.service.cart;

import java.util.Objects;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.AddToCartUseCase;
import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.ProductNotFoundException;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.NotEnoughItemsInStockException;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddToCartService implements AddToCartUseCase {

	private final ProductRepository productRepository;
	private final CartRepository cartRepository;

	@Override
	public Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
			throws ProductNotFoundException, NotEnoughItemsInStockException {
		Objects.requireNonNull(customerId, "customerId must not be null");
		Objects.requireNonNull(productId, "productId must not be null");
		if (quantity < 1) {
			throw new IllegalArgumentException("quantity must be greater than 0");
		}

		Product product = productRepository
							.findById(productId)
							.orElseThrow(ProductNotFoundException::new);
		Cart cart = cartRepository
							.findByCustomerId(customerId)
							.orElseGet(() -> new Cart(customerId));
		cart.addProduct(product, quantity);
		cartRepository.save(cart);
		return cart;
	}
	
}
