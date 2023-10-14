package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.config;

import java.util.function.Supplier;

import javax.transaction.Transactional;

public class TransactionalUseCaseExecutor {
	
	@Transactional
	<T> T executeInTransaction(Supplier<T> execution) {
		return execution.get();
	}
}
