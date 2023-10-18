package com.farhad.example.shopping.api;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.farhad.example.shopping.core.ShoppingItem;
import com.farhad.example.shopping.core.ShoppingList;
import com.farhad.example.shopping.core.ShoppingListRepository;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {

	@Mock
	private ShoppingListRepository shoppingListRepository;

	private ShoppingListService shoppingListService;

	@BeforeEach
	public void setup() {
		shoppingListService = new ShoppingListService(shoppingListRepository);
	}

	@Test
	public void createShoppingList() {
		// given
		Mockito.when(shoppingListRepository.save(any(ShoppingList.class)))
				.thenAnswer(i -> i.getArguments()[0]);
		// when
		UUID shoppingListId = shoppingListService.createShoppingList();

		// then
		assertNotNull(shoppingListId);

		verify(shoppingListRepository, times(1)).save(any());
		verifyNoMoreInteractions(shoppingListRepository);

	}

	@Test
	public void addItemToShoppingList() {

		// given
		ShoppingList shoppingList = ShoppingList.of();
		doReturn(shoppingList).when(shoppingListRepository).findByIdOrFail(any());
		doReturn(shoppingList).when(shoppingListRepository).save(any());
		ShoppingItem milkItem = ShoppingItem.of("milk", 3.8d, 1);
		// when
		UUID shoppingItemId = shoppingListService.addItemToShoppingList(
				shoppingList.getId(),
				milkItem.getProductName(),
				milkItem.getPrice(),
				milkItem.getQuantity());
		// then
		assertNotNull(shoppingItemId);
		ShoppingItem actualShoppingItem = shoppingList.getItem(shoppingItemId);
		assertAll(
				() -> assertEquals(milkItem.getProductName(), actualShoppingItem.getProductName()),
				() -> assertEquals(milkItem.getPrice(), actualShoppingItem.getPrice()),
				() -> assertEquals(milkItem.getQuantity(), actualShoppingItem.getQuantity()));
		verify(shoppingListRepository, times(1)).findByIdOrFail(any());
		verify(shoppingListRepository, times(1)).save(any());
		verifyNoMoreInteractions(shoppingListRepository);
	}

	@Test
	void getTotalPrice() {
		// given
		ShoppingList shoppingList = ShoppingList.of();
		ShoppingItem milkItem = ShoppingItem.of("milk", 3.8d, 100);
		shoppingList.addItem(milkItem);

		doReturn(shoppingList).when(shoppingListRepository).findByIdOrFail(any());

		// when
		double totalPrice = shoppingListService.getTotalPrice(shoppingList.getId());

		// then
		assertEquals(milkItem.getSubTotalPrice(), totalPrice);

		verify(shoppingListRepository, times(1)).findByIdOrFail(any());
		verifyNoMoreInteractions(shoppingListRepository);
	}
}
