package com.farhad.example.dddhibernatedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farhad.example.dddhibernatedemo.domain.Customer;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByEmail(@Param("email") String email);
}
