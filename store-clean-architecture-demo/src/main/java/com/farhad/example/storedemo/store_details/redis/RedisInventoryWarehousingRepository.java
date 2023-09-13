package com.farhad.example.storedemo.store_details.redis;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import com.farhad.example.storedemo.store_core.variants.InventoryItem;
import com.farhad.example.storedemo.store_core.variants.InventoryWarehousingRepository;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.RequiredArgsConstructor;
import redis.clients.jedis.Jedis;

@RequiredArgsConstructor
public class RedisInventoryWarehousingRepository implements InventoryWarehousingRepository {

	private final Jedis redisClient;
	@Override
	public void stock(Sku sku, List<InventoryItem> items) {
		redisClient.sadd(
				sku.getValue(), 
				items.stream()
						.map(InventoryItem::getSerialNumber)
						.collect(toList())
						.toArray(new String[0]));
	}

	@Override
	public Long checkInventoryCount(Sku sku) {
		return redisClient.scard(sku.getValue());
	}

	@Override
	public Optional<InventoryItem> reserveItem(Sku sku) {
		String serial = redisClient.spop(sku.getValue());
		if(serial == null || serial.trim().isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(new InventoryItem(serial));
	}

	@Override
	public void replaceItem(Sku sku, InventoryItem item) {
		redisClient.sadd(sku.getValue(), item.getSerialNumber());
	}

	
}
