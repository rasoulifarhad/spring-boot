package com.farhad.example.storedemo.store_app.http;

import static java.util.stream.Collectors.toList;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.storedemo.store_app.http.api.orders.OrderApiResponse;
import com.farhad.example.storedemo.store_app.http.api.orders.OrderRequest;
import com.farhad.example.storedemo.store_app.http.api.orders.PreviousCustomerOrderResponse;
import com.farhad.example.storedemo.store_core.common.Pair;
import com.farhad.example.storedemo.store_core.orders.Order;
import com.farhad.example.storedemo.store_core.orders.OrderProcessingService;
import com.farhad.example.storedemo.store_core.orders.OrderQueryService;
import com.farhad.example.storedemo.store_core.orders.OrderResult;
import com.farhad.example.storedemo.store_core.orders.OrderResult.OrderSuccess;
import com.farhad.example.storedemo.store_core.orders.PlaceOrderCommand;
import com.farhad.example.storedemo.store_core.security.StoreAuthProvider;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController {
	private final StoreAuthProvider storeAuthProvider;
	private final OrderProcessingService orderProcessingService;
	private final OrderQueryService orderQueryService;

	@GetMapping("/orders")
	public ResponseEntity<PreviousCustomerOrderResponse> listOrdersForUser() {
		log.info("Fetching orders for user {}", storeAuthProvider.getCurrentUser());
		List<Order> foundOrders = orderQueryService.retrieveOrdeersForUser(storeAuthProvider.getCurrentUser());
		return new ResponseEntity<PreviousCustomerOrderResponse>(PreviousCustomerOrderResponse.from(foundOrders), HttpStatus.OK);
	}

	@PostMapping("/orders")
	public ResponseEntity<OrderApiResponse> processOrder(@RequestBody OrderRequest orderRequest) {
		OrderResult orderResult = orderProcessingService.placeOrder(
										new PlaceOrderCommand(
											storeAuthProvider.getCurrentUser(), 
											orderRequest.getItems().entrySet().stream()
													.map(entry -> 
															new Pair<Sku, Integer>(new Sku(entry.getKey()), entry.getValue())) 
													.collect(toList())));
		if (orderResult instanceof OrderSuccess) {
			log.info("Order was successful");
			return new ResponseEntity<OrderApiResponse>(
					new OrderApiResponse(
								true, 
								((OrderSuccess)orderResult).getOrderId().getValue(), 
								((OrderSuccess)orderResult).getTime()), 
					HttpStatus.OK);
		} else {
			log.info("Order failed");
			return new ResponseEntity<OrderApiResponse>(
					new OrderApiResponse(
								false, 
								"", 
								Instant.now()), 
					HttpStatus.OK);
		}
	}
}
