package com.farhad.example.springdatajpa.anothermanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.anothermanytomany.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
