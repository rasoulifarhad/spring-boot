package com.farhad.example.storedemo.store_core.variants;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.farhad.example.storedemo.store_core.common.Pair;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class InventoryManagementService {
	
	private final ProductVariantRepository productVariantRepository;
	private final InventoryWarehousingRepository inventoryWarehousingRepository;

	public void receiveNewItems(ProductVariant variant, List<InventoryItem> items) {
		productVariantRepository.registerNewVariants(Arrays.asList(variant));
		inventoryWarehousingRepository.stock(variant.getSku(), items);
		log.info("Stocked {} items for variant {}", items.size(), variant);
	}

	public Long getInventoryCount(ProductVariant variant) {
		return inventoryWarehousingRepository.checkInventoryCount(variant.getSku());
	}

	public Optional<InventoryItem> holdForOrder(ProductVariant variant) {
		return holdForOrder(variant.getSku());
	}

	public Optional<InventoryItem> holdForOrder(Sku sku) {
		return inventoryWarehousingRepository.reserveItem(sku);
	}

	public void restockItem(ProductVariant variant, InventoryItem item) {
		inventoryWarehousingRepository.replaceItem(variant.getSku(), item);
	}

	public Optional<Pair<ProductVariant, Long>> retrieveVariantsAndCount(Sku sku) {
		Optional<ProductVariant>  productVariant = productVariantRepository.findById(sku);
		if(productVariant.isPresent()) {	
			Long count = inventoryWarehousingRepository.checkInventoryCount(sku);
			return Optional.of(new Pair<ProductVariant,Long>(productVariant.get(), count));
		}
		return Optional.empty();
	}
}
