package com.farhad.example.springdatajpa.anotheronetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.anotheronetomany.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByEmployeeId(Long employeeId); 
}
