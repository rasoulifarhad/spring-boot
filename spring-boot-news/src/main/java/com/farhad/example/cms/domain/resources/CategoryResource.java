package com.farhad.example.cms.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.cms.domain.models.Category;
import com.farhad.example.cms.domain.service.CategoryService;
import com.farhad.example.cms.domain.vo.CategoryRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Api(tags = "category", description = "Category API")
public class CategoryResource {
	

	private final CategoryService categoryService;

	@GetMapping("/{id}")
  	@ApiOperation(value = "Find category",notes = "Find the Category by ID")
  	@ApiResponses(value = {
    	@ApiResponse(code = 200,message = "Category found"),
    	@ApiResponse(code = 404,message = "Category not found"),
  	})	
	public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
		return ResponseEntity.ok(categoryService.findOne(id));
	}

	@ApiOperation(value = "List categories",notes = "List all categories")
	@ApiResponses(value = {
		@ApiResponse(code = 200,message = "Categories found"),
		@ApiResponse(code = 404,message = "Categories not found")
	})	
	@GetMapping
	public ResponseEntity<Iterable<Category>> findAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}

	@PostMapping
	@ApiOperation(value = "Create category",notes = "It permits to create a new category")
	@ApiResponses(value = {
		@ApiResponse(code = 201,message = "Category created successfully"),
		@ApiResponse(code = 400,message = "Invalid request")
	})	
	public ResponseEntity<Category> newCategory(@RequestBody CategoryRequest category) {
		return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
	}

	@PostMapping("/{id}")
	@ApiOperation(value = "Update category",notes = "It permits to update a category")
	@ApiResponses(value = {
		@ApiResponse(code = 200,message = "Category update successfully"),
		@ApiResponse(code = 404,message = "Category not found"),
		@ApiResponse(code = 400,message = "Invalid request")
	})	
	public ResponseEntity<Category> updateCategory(@PathVariable("id") String id,  @RequestBody CategoryRequest category) {
		return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove category",notes = "It permits to remove a category")
	@ApiResponses(value = {
		@ApiResponse(code = 200,message = "Category removed successfully"),
		@ApiResponse(code = 404,message = "Category not found")
	})	
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") String id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
