package com.farhad.example.cms.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.farhad.example.cms.domain.models.Category;
import com.farhad.example.cms.domain.repository.CategoryRepository;
import com.farhad.example.cms.domain.vo.CategoryRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository  categoryRepository;

	public Category update(String id, CategoryRequest categoryRequest) {
		final Category category = categoryRepository.findOne(id);
		category.setName(categoryRequest.getNamne());
		return categoryRepository.save(category);
	}

	public Category create(CategoryRequest categoryRequest) {
		Category category = new Category();
		category.setId(UUID.randomUUID().toString());
		category.setName(categoryRequest.getNamne());
		return categoryRepository.save(category);
	}

	public void delete(String id) {
		Category category = categoryRepository.findOne(id);
		categoryRepository.delete(category);
	}

	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findOne(String id) {
		return categoryRepository.findOne(id);
	}

}

