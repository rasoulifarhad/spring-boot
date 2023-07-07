package com.farhad.example.springdatajpa.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.manytomany.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
