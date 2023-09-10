package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.cart;

import com.farhad.example.hexagonalorderdemo.shop.model.cart.CartLineItem;
import com.farhad.example.hexagonalorderdemo.shop.model.money.Money;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartLineItemDto {
	private String productId;
	private String productName;
	private Money price;
	private int quantity;

	public static CartLineItemDto fromDomainModel(CartLineItem cartLineItem) {
		Product product = cartLineItem.product();
		return new CartLineItemDto(
			product.id().getValue(), 
			product.name(), 
			product.price(), 
			cartLineItem.quantity()); 
	}
}
