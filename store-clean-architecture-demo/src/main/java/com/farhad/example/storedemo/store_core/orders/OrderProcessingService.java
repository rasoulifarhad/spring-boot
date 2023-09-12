package com.farhad.example.storedemo.store_core.orders;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import com.farhad.example.storedemo.store_core.common.Pair;
import com.farhad.example.storedemo.store_core.orders.OrderResult.OrderSuccess;
import com.farhad.example.storedemo.store_core.produtcs.Shoe;
import com.farhad.example.storedemo.store_core.produtcs.ShoeService;
import com.farhad.example.storedemo.store_core.variants.InventoryItem;
import com.farhad.example.storedemo.store_core.variants.InventoryManagementService;
import com.farhad.example.storedemo.store_core.variants.ProductVariant;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderProcessingService {
	
	private final OrderRepository orderRepository;
	private final InventoryManagementService inventoryManagementService;
	private final ShoeService shoeService;

	public OrderResult placeOrder(PlaceOrderCommand command) {
		Order order = new Order(OrderId.newId(), command.getUser(), Instant.now());

		// 'hold' inventory from the warehouse for the skus
        // on an error, restore the inventory
		command.getItems().forEach(pair -> {
			// ugh more loops while fetching. Who even wrote this?
			Sku sku = pair.getLeft();
			Integer quantity = pair.getRight();
			Optional<Pair<ProductVariant, Long>> optionalVariantData =  inventoryManagementService.retrieveVariantsAndCount(sku);
			if (optionalVariantData.isPresent()) {
				Pair<ProductVariant, Long> variantData = optionalVariantData.get();
				Optional<Shoe> actualShoe = shoeService.get(variantData.getLeft().getShoeId());
				if (actualShoe.isPresent()) {
					Optional<InventoryItem> optionalOfPhysicalInventoryItem =  inventoryManagementService.holdForOrder(variantData.getLeft());
					if (optionalOfPhysicalInventoryItem.isPresent()) {
						// no... we want the sku, the price, but the actual inventory item
						order.addItem(
								variantData.getLeft(), 
								actualShoe.get().getPrice(), 
								Arrays.asList(optionalOfPhysicalInventoryItem.get()));
					} else {
						// return new  OrderFailure("No Items remaining!");
					}
				} else {
					// 	return 	new OrderFailure("Unknown shoe " + variantData.getLeft().getShoeId());
				}
			} else {
				// 	return new OrderFailure("Unknown sku " + sku);
			}
		});

		log.info("Total cost of {} is {}", command.getItems().size(), order.getPrice());
        // assume that other operations - likely actually handing payments - are ... taken care of. Hand wave away!
		orderRepository.submitOrder(order);
		return new OrderSuccess(order.getId(), order.getPrice(), order.getTime());
	}

}
