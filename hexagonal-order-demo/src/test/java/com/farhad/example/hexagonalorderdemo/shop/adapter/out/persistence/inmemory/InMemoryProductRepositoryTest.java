package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.inmemory;

import com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.AbstractProductRepositoryTest;

public class InMemoryProductRepositoryTest extends AbstractProductRepositoryTest<InMemoryProductRepository> {

	@Override
	protected InMemoryProductRepository createProductRepository() {
		return new InMemoryProductRepository();
	}

	
}
