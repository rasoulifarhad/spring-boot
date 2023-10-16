package com.farhad.example.dddmonolithic.infrastructure.repositories.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.dddmonolithic.infrastructure.repositories.dataentity.ProductDataEntity;

public interface ProductJpaPersistence  extends JpaRepository<ProductDataEntity, Long> {
	

}
