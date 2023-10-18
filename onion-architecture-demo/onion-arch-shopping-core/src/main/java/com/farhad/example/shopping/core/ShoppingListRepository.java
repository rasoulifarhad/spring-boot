package com.farhad.example.shopping.core;

import java.util.Optional;
import java.util.UUID;

public interface ShoppingListRepository {
	
	ShoppingList save(ShoppingList shoppingList);
	Optional<ShoppingList> findById(UUID id);
	void deleteAll();

	default ShoppingList findByIdOrFail(UUID id) {
		return findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Item with id: <" + id + "> not found!"));
	}
}
