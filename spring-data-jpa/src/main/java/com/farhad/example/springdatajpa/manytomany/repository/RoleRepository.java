package com.farhad.example.springdatajpa.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.manytomany.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}