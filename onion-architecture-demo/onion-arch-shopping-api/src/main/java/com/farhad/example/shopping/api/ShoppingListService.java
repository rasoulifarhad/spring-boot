package com.farhad.example.shopping.api;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farhad.example.shopping.core.ShoppingItem;
import com.farhad.example.shopping.core.ShoppingList;
import com.farhad.example.shopping.core.ShoppingListRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoppingListService {
	
	private final ShoppingListRepository shoppingListRepository;

	@Transactional
	public UUID createShoppingList() {
		ShoppingList shoppingList = ShoppingList.of();
		shoppingList = shoppingListRepository.save(shoppingList);
		log.info("Created a new ShoppingList <id: {}>", shoppingList.getId());
		return shoppingList.getId();
	}

	@Transactional
	public UUID addItemToShoppingList(UUID shoppingListId, String productName, double price, int quantity) {
		ShoppingList shoppingList = shoppingListRepository.findByIdOrFail(shoppingListId);
		ShoppingItem shoppingItem = ShoppingItem.of(productName, price, quantity);
		shoppingList.addItem(shoppingItem);
		shoppingList = shoppingListRepository.save(shoppingList);
		log.info("Added a new item <{}> to the ShoppingList <id: {}>",
            				shoppingItem, shoppingList.getId());
		return shoppingItem.getId();
	}

	@Transactional
	public double getTotalPrice(UUID shoppingListId) {
		ShoppingList shoppingList = shoppingListRepository.findByIdOrFail(shoppingListId);
		log.info("Retrieved the totalPrice={} for ShoppingList <id: {}>",
									shoppingList.getTotalPrice(), shoppingListId);
		return shoppingList.getTotalPrice();
	}
}
