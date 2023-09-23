package com.farhad.example.election_layer.domain.election;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.election_layer.domain.election.Election.ElectionId;

public interface ElectionRepository extends CrudRepository<Election, ElectionId> {
    
}
