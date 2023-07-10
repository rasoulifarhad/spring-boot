package com.farhad.example.springdatajpa.anotheronetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.anotheronetomany.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
