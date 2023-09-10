package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

public final class ProductIdParser {
	
	private ProductIdParser() {}

	public static ProductId parseProductId(String productIdString) {
		if(productIdString == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing 'productId'");
		}
		try {
			return new ProductId(productIdString);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid 'productId'");
		}
	}

}
