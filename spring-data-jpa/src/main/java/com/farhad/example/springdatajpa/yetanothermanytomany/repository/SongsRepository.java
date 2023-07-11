package com.farhad.example.springdatajpa.yetanothermanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.yetanothermanytomany.model.Songs;

public interface SongsRepository extends JpaRepository<Songs, Long>{
    
}
