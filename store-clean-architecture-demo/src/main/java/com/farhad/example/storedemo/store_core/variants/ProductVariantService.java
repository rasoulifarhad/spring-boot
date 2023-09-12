package com.farhad.example.storedemo.store_core.variants;

import java.util.List;

import com.farhad.example.storedemo.store_core.produtcs.ShoeId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductVariantService {
	
	private final ProductVariantRepository productVariantRepository;

	public List<ProductVariant> listForId(ShoeId shoeId) {
		return productVariantRepository.findAllVariantForShoe(shoeId);
	}
}
