package com.farhad.example.storedemo.store_core.variants;

import com.farhad.example.storedemo.store_core.produtcs.ShoeId;

import lombok.Value;

// When you shop online, you notice that the same product is available in various sizes, colors, materials and price points. These 
// purchasing options are product variants.
//
// A specific item that is bundled in with related variants to form one distinguishable product is known as a product variant.
@Value
public class ProductVariant {
	
	private Sku sku;
	private ShoeId ShoeId;
	private String label;
	private VariantSize size;
	private VariantColor color;

	
	@Override
	public String toString() {
		return String.format("Variant: '%s' ($s) %s, %s", label, sku, size, color);
	}
}
