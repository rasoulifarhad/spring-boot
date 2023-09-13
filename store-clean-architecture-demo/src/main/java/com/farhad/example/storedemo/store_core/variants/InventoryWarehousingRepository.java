package com.farhad.example.storedemo.store_core.variants;

import java.util.List;
import java.util.Optional;

public interface 	InventoryWarehousingRepository {
	
	void stock(Sku sku, List<InventoryItem> items);
	Long checkInventoryCount(Sku sku);
	Optional<InventoryItem> reserveItem(Sku sku);
	void replaceItem(Sku sku, InventoryItem item);
}
