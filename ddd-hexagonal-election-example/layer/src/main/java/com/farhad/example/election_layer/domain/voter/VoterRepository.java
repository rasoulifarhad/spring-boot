package com.farhad.example.election_layer.domain.voter;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.election_layer.domain.voter.Voter.VoterId;

public interface VoterRepository extends CrudRepository<Voter, VoterId> {
    
}
