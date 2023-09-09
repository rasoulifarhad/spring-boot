package com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart;

import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.NotEnoughItemsInStockException;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

public interface AddToCartUseCase {
	Cart addToCart(CustomerId customerId, ProductId productId, int quantity) throws ProductNotFoundException, NotEnoughItemsInStockException;
}
