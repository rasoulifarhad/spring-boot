package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.inmemory;

import com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.AbstractCartRepositoryTest;

public class InMemoryCartRepositoryTest extends AbstractCartRepositoryTest<InMemoryCartRepository, InMemoryProductRepository> {

	@Override
	protected InMemoryCartRepository createCartRepository() {
		return new InMemoryCartRepository();
	}

	@Override
	protected InMemoryProductRepository createProductRepository() {
		return new InMemoryProductRepository();
	}

}
