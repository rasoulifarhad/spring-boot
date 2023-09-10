package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.product;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.product.FindProductUseCase;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FindProductController {
	
	private final FindProductUseCase findProductUseCase;

	// http://host:port/products/?query={query}
	@GetMapping(path = "/products", produces = "application/json")
	public List<ProductDto> findProducts(@RequestParam(name = "query") String query) {
		if(query == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing 'query'");
		}
		List<Product> products;
		try {
			products = findProductUseCase.findByNameOrDescription(query);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid 'query'");
		}
		return products.stream().map(ProductDto::fromDomainModel).collect(toList());
	}
}
