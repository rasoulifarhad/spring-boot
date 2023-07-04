package com.farhad.example.springdatajpa.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.onetomany.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
