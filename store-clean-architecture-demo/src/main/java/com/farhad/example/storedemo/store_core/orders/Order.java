package com.farhad.example.storedemo.store_core.orders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.storedemo.store_core.money.Money;
import com.farhad.example.storedemo.store_core.security.PrincipalUser;
import com.farhad.example.storedemo.store_core.variants.InventoryItem;
import com.farhad.example.storedemo.store_core.variants.ProductVariant;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.Getter;

@Getter
public class Order {
	private OrderId id;
	private PrincipalUser user;
	private Instant time;
	private List<OrderLineItem> items = new ArrayList<>();	
	private Money price;
	
	public Order(OrderId id, PrincipalUser user, Instant time) {
		this.id = id;
		this.user = user;
		this.time = time;
	}

	public void addItem(ProductVariant item, Money pricePer, List<InventoryItem> inventoryItems) {
		addItem(item.getSku(), pricePer, inventoryItems);
	}
	
	
	public void addItem(Sku sku, Money pricePer, List<InventoryItem> inventoryItems) {
		items.add(new OrderLineItem(sku, pricePer, inventoryItems));
		price = price.add( pricePer.multiply(inventoryItems.size()) );
	}

	@Override
	public String toString() {
		return String.format("Order: %s %s : %s : %s, $s ", 
			id, time, price, user, items.size());
	}

	
}
