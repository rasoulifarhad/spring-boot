package com.farhad.example.election_layer.domain.election;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ElectionRepository extends CrudRepository<Election, UUID> {
    
}
