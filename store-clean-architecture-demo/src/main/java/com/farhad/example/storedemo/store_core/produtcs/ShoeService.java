package com.farhad.example.storedemo.store_core.produtcs;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShoeService {
	
	private final ShoeRepository shoeRepository;

	public Optional<Shoe> get(ShoeId id){
		return shoeRepository.findById(id);
	}

	public List<Shoe> search(ShoeLookupQuery query) {
		if(query.isEmpty()) {
			return shoeRepository.list();
		} else if (query.getByName() != null) {
			return shoeRepository.findByName(query.getByName());
		} else {
			return shoeRepository.findByPriceUnder(query.getByPrice());
		}
	}
}
