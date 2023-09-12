package com.farhad.example.storedemo.store_core.variants;

import java.util.List;
import java.util.Optional;

import com.farhad.example.storedemo.store_core.produtcs.ShoeId;

public interface ProductVariantRepository {
	
	List<ProductVariant> findAllVariantForShoe(ShoeId id);
	Optional<ProductVariant> findById(Sku sku);
	void registerNewVariants(List<ProductVariant> variants);
}
