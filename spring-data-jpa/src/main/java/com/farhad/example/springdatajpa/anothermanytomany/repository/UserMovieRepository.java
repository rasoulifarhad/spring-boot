package com.farhad.example.springdatajpa.anothermanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.anothermanytomany.model.UserMovie;
import com.farhad.example.springdatajpa.anothermanytomany.model.UserMovie.UserMovieId;

public interface UserMovieRepository extends JpaRepository<UserMovie, UserMovieId> {
    
}
