package com.farhad.example.dddhibernatedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farhad.example.dddhibernatedemo.domain.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long>{

}
