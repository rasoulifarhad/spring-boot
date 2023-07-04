package com.farhad.example.springdatajpa.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.onetomany.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
