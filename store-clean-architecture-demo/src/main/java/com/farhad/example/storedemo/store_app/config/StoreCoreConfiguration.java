package com.farhad.example.storedemo.store_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.farhad.example.storedemo.store_core.orders.OrderAdminService;
import com.farhad.example.storedemo.store_core.orders.OrderProcessingService;
import com.farhad.example.storedemo.store_core.orders.OrderQueryService;
import com.farhad.example.storedemo.store_core.orders.OrderRepository;
import com.farhad.example.storedemo.store_core.produtcs.ShoeService;
import com.farhad.example.storedemo.store_core.security.PrincipalUser;
import com.farhad.example.storedemo.store_core.security.StoreAuthProvider;
import com.farhad.example.storedemo.store_core.variants.InventoryManagementService;
import com.farhad.example.storedemo.store_core.variants.ProductVariantService;
import com.farhad.example.storedemo.store_details.postgres.H2OrderRepository;
import com.farhad.example.storedemo.store_details.postgres.H2ProductVariantRepository;
import com.farhad.example.storedemo.store_details.postgres.H2ShoeRepository;
import com.farhad.example.storedemo.store_details.redis.RedisInventoryWarehousingRepository;
import com.farhad.example.storedemo.store_details.security.FakeStoreAuthProvider;

import redis.clients.jedis.Jedis;

@Configuration
public class StoreCoreConfiguration {
	
	@Bean
	public ShoeService getShoeService(JdbcTemplate jdbcTemplate) {
		return new ShoeService(
			new H2ShoeRepository(jdbcTemplate));
	}

	@Bean
	public ProductVariantService getProductVariantService(JdbcTemplate jdbcTemplate) {
		return new ProductVariantService(
			new H2ProductVariantRepository(jdbcTemplate));
	}

	@Bean
	public InventoryManagementService getInventoryManagementService(JdbcTemplate jdbcTemplate, Jedis jedis) {
		return new InventoryManagementService(
			new H2ProductVariantRepository(jdbcTemplate), 
			new RedisInventoryWarehousingRepository(jedis));
	}

	@Bean
	public OrderRepository getOrderRepository(JdbcTemplate jdbcTemplate) {
		return new H2OrderRepository(jdbcTemplate);
	}

	@Bean
	public OrderProcessingService getOrderProcessingService(OrderRepository orderRepository,InventoryManagementService inventoryManagementService, ShoeService shoeService) {
		return new OrderProcessingService(orderRepository, inventoryManagementService, shoeService);
	}

	@Bean
	public OrderAdminService getAdminService(OrderRepository orderRepository) {
		return new OrderAdminService(orderRepository);
	}

	@Bean 
	public OrderQueryService getOrderQueryService(OrderRepository orderRepository) {
		return new OrderQueryService(orderRepository);
	}

	@Bean
	public StoreAuthProvider getStoreAuthProvider() {
		FakeStoreAuthProvider storeAuthProvider = new FakeStoreAuthProvider();
		storeAuthProvider.login(new PrincipalUser("anyone", "anyone@example.com"));
		return storeAuthProvider;
	}
}
