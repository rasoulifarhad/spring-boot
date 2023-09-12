package com.farhad.example.storedemo.store_core.orders;

import java.util.List;

import com.farhad.example.storedemo.store_core.money.Money;
import com.farhad.example.storedemo.store_core.variants.InventoryItem;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.Value;

@Value
public class OrderLineItem {
	
	private Sku sku;
	private Money pricePer;
	private List<InventoryItem> inventoryItems;
}
