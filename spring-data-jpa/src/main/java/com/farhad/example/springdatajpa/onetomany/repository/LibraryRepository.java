package com.farhad.example.springdatajpa.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.onetomany.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    
}
