package com.farhad.example.storedemo.store_app.http;

import static java.util.stream.Collectors.toList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.storedemo.store_app.http.api.shoes.ShoeData;
import com.farhad.example.storedemo.store_app.http.api.shoes.ShoeResults;
import com.farhad.example.storedemo.store_core.produtcs.Shoe;
import com.farhad.example.storedemo.store_core.produtcs.ShoeLookupQuery;
import com.farhad.example.storedemo.store_core.produtcs.ShoeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ShoeController {
	
	private final ShoeService shoeService;

	@GetMapping("/shoes")
	public ShoeResults listShoes(@RequestParam String name) {
		ShoeLookupQuery query = new ShoeLookupQuery(name, null);
		return new ShoeResults( shoeService
				.search(query)
				.stream()
				.map(this::convert)
				.collect(toList()));
	}

	private ShoeData convert(Shoe shoe) {
		return new ShoeData(
					shoe.getId().getValue(), 
					shoe.getName(), 
					shoe.getDescription(), 
					shoe.getPrice());
	}
}
