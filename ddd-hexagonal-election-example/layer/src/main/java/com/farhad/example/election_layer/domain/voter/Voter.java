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
    // private final UUID id;
    private final VoterId id;

    private final String name;

    
    public Voter(String name) {
        this(null, name);
    }

    @With
    @Value
    @AllArgsConstructor
    public static class VoterId {
        private final UUID value;

        public static VoterId id() {
            return new VoterId(UUID.randomUUID());
        }

        public static VoterId fromString(String uuidString) {
            return new VoterId(UUID.fromString(uuidString));
        }

    }

    
}
