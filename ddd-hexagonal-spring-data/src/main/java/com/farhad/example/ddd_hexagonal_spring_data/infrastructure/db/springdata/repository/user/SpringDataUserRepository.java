package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.user.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long>{
    
}
