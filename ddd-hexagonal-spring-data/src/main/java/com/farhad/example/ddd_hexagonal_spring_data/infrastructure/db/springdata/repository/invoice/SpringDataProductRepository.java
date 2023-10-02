package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.ProductEntity;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long>{
    
}
