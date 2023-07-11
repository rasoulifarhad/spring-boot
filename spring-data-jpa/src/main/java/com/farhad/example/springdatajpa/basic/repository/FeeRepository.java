package com.farhad.example.springdatajpa.basic.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.basic.model.Fee;

public interface FeeRepository extends JpaRepository<Fee, UUID> {
    List<Fee> findByClientId(String clientId);
    
}
