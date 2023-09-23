package com.farhad.example.election_layer.domain.voter;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface VoterRepository extends CrudRepository<Voter, UUID> {
    
}
