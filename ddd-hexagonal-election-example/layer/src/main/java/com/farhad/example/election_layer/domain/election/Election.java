package com.farhad.example.election_layer.domain.election;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceCreator;

import com.farhad.example.election_layer.domain.candidate.Candidate;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

@With
@Value
@AllArgsConstructor(onConstructor = @__({@PersistenceCreator}))
public class Election {
    
    @Id
    // private final UUID id;
    private final ElectionId id;

    private final String name;
    private final Collection<CandidateRef> candidates;
    
    @With
    @Value
    @AllArgsConstructor
    public static class ElectionId {
        private final UUID value;

        public static ElectionId id() {
            return new ElectionId(UUID.randomUUID());
        }

        public static ElectionId fromString(String uuidString) {
            return new ElectionId(UUID.fromString(uuidString));
        }

    }

    public Election(String name) {
        this(null, name, new CopyOnWriteArrayList<>());
    }

    public Election registerCandidates(Candidate... candidates) {
        requireNonNull(candidates);
        this.candidates.addAll( Arrays.stream(candidates)
                                    .map(Candidate::getId)
                                    .map(CandidateRef::of)
                                    .collect(toList()));
        return this;
    }

    
}
