package com.farhad.example.hexagonalorderdemo.shop.model.cart;

import com.farhad.example.hexagonalorderdemo.shop.model.money.Money;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class CartLineItem {

	private final Product product;
	private int quantity;

	public void increaseQuantityBy(int value, int itemsInStock) throws NotEnoughItemsInStockException {
		if (value < 1) {
			throw new IllegalArgumentException("you must add at least one item");
		}
		int newQuantity = quantity + value;
		if(itemsInStock < newQuantity) {
			throw new NotEnoughItemsInStockException(
				String.format("Product %s has less items in stock (%d) than the requested total quantity (%d)", 
									product.id(), 
									product.itemsInStock(), 
									newQuantity), 
				product.itemsInStock());
		}
		this.quantity = newQuantity;
	}

	public Money subTotal() {
		return product.price().multiply(quantity); 
	}
}
