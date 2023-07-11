package com.farhad.example.springdatajpa.yetanothermanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.yetanothermanytomany.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
