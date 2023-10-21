package com.farhad.example.petclinic.infrastructure.adapter.out.persistance.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public abstract class InMemoryRepository<T> {
	
	private final Map<Long, T> storage = new HashMap<>();
	private AtomicLong idGenerator = new AtomicLong();

	private long nextId() {
		return idGenerator.incrementAndGet();
	}

	protected List<T> getAll() {
		return new ArrayList<>(storage.values());
	}

	protected Optional<T> get(Long id) {
		return Optional.ofNullable(storage.get(id));
	}

	protected Long add(T entity) {
		Long id = Long.valueOf(nextId());
		storage.put(id, entity);
		return id;
	}
}
