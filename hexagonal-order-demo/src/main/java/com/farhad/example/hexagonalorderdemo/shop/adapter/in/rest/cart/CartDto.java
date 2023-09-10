package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.cart;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.money.Money;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {

	private List<CartLineItemDto> lineItems;
	private int numberOfItems;
	private Money subTotal;
	
	public static CartDto fromDomainModel(Cart cart) {
		return new CartDto(
			cart.lineItems().stream().map(CartLineItemDto::fromDomainModel).collect(toList()), 
			cart.numberOfItems(), 
			cart.subTotal());
	}
	
}
