package com.farhad.example.springdatajpa.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.manytomany.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
