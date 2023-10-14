package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.entity.PaymentEntity;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
	
}
