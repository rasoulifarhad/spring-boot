package com.farhad.example.shopping.infra.api.rest;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.noNullElements;
import static org.apache.commons.lang3.Validate.notNull;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.farhad.example.shopping.api.ShoppingListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/shoppinglists")
@Api(value = "API to shopping list", produces = "application/json")
@RequiredArgsConstructor
public class ShoppingListController {

	protected static final String BASE_URI = "/api/v1/shoppinglists";
	private final ShoppingListService shoppingListService;

	@PostMapping
	@ApiOperation(value = "Create new shopping list", produces = "application/json")
	ResponseEntity<?> createShoppingList(UriComponentsBuilder uriComponentsBuilder) {
		UriComponents uriComponents = uriComponentsBuilder
							.path(BASE_URI + "/{shoppingListId}")
							.buildAndExpand(
								shoppingListService.createShoppingList());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PostMapping("/{shoppingListId}/items")
    @ApiOperation(value = "Add new item to a shopping list", produces = "application/json")
	ResponseEntity<?> addItemToShoppingList(
				UriComponentsBuilder uriComponentsBuilder,
				@PathVariable UUID shoppingListId,
				@RequestParam String productName,
				@RequestParam Double price,
				@RequestParam Integer quantity) {

		noNullElements(Arrays.asList(shoppingListId, productName, price, quantity),
					"Invalid input parameter/-s: shoppingListId=%s, productName=%s, price=%f, quantity=%d",
							shoppingListId, productName, price, quantity);
				
		isTrue(quantity >= 1, "The quantity has to be greater or equal to 1");

		UriComponents uriComponents = 
			uriComponentsBuilder
				.path(BASE_URI+ "/" + shoppingListId + "/items/{itemId}")
				.buildAndExpand(
					shoppingListService.addItemToShoppingList(shoppingListId, productName, price, quantity));
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@GetMapping("/{shoppingListId}/totalprice")
    @ApiOperation(value = "Get shopping list's total price, with the shipping costs of 10 credits included"
        +" (if the price is >=100 credits, then the shipping is free of charge)!",
        produces = "application/json")
	ResponseEntity<?> getTotalPrice(@PathVariable UUID shoppingListId) {
		notNull(shoppingListId,"Missing mandatory input parameter: shoppingListId");
		return ResponseEntity.ok().body(shoppingListService.getTotalPrice(shoppingListId));
	}
	
}
