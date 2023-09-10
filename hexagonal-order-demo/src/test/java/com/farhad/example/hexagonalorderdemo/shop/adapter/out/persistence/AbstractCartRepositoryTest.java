package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence;

import org.junit.jupiter.api.BeforeEach;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;

public abstract class AbstractCartRepositoryTest<T extends CartRepository> {
	
	private T cartRepository;

	protected abstract T createCartRepository();

	@BeforeEach
	void initRepository() {
		cartRepository = createCartRepository();
	}
}
