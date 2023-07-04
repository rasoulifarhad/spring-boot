package com.farhad.example.springdatajpa.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.springdatajpa.onetoone.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
    
}
