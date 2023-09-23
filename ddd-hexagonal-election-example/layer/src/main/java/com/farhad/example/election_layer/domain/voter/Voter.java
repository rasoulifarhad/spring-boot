package com.farhad.example.election_layer.domain.voter;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceCreator;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

@With
@Value
@AllArgsConstructor(onConstructor = @__({@PersistenceCreator}))
public class Voter {
    
    @Id
    private final UUID id;
    private final String name;
    
    public Voter(String name) {
        this(null, name);
    }

    
}
