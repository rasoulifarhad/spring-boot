package com.farhad.example.cms.domain.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRepository<T> {
	
	private final List<T> elements = new ArrayList<>();

	public void delete(T entity) {
		final Iterator<T> iterator = elements.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (next.equals(entity)) {
				iterator.remove();
				break;
			}
		}
	}

	public List<T> findAll() {
		return new ArrayList<>(elements);
	}

	public T save(T entity) {
		elements.add(entity);
		return entity;
	}

	public T findOne(String id) {
		return elements.stream()
				.filter(e -> e.equals(id))
				.findFirst()
				.get();
	}
}
