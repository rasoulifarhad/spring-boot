package com.farhad.example.springdatajpa.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.manytomany.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
