package com.farhad.example.springdatajpa.basic.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.basic.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
    Optional<Contract> findByClientId(String clientId);
}
