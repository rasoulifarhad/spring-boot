package com.farhad.example.storedemo.store_details.redis;

import java.util.List;
import java.util.Optional;

import com.farhad.example.storedemo.store_core.variants.InventoryItem;
import com.farhad.example.storedemo.store_core.variants.InventoryWarehousingRepository;
import com.farhad.example.storedemo.store_core.variants.Sku;

public class RedisInventoryWarehousingRepository implements InventoryWarehousingRepository {

	@Override
	public void stock(Sku sku, List<InventoryItem> items) {
		throw new UnsupportedOperationException("Unimplemented method 'stock'");
	}

	@Override
	public Long checkInventoryCount(Sku sku) {
		throw new UnsupportedOperationException("Unimplemented method 'checkInventoryCount'");
	}

	@Override
	public Optional<InventoryItem> reserveItem(Sku sku) {
		throw new UnsupportedOperationException("Unimplemented method 'reserveItem'");
	}

	@Override
	public void replaceItem(Sku sku, InventoryItem item) {
		throw new UnsupportedOperationException("Unimplemented method 'replaceItem'");
	}

	
}
