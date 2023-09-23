package com.farhad.example.election_layer.domain.candidate;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.StreamSupport;

import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceCreator;

import com.farhad.example.election_layer.domain.voter.Voter;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

@With
@Value
@AllArgsConstructor(onConstructor=@__({@PersistenceCreator}))
public class Candidate implements Comparable<Candidate> {

    @Id
    // private final UUID id;
    private final CandidateId id;

    private final String name;
    private final Collection<VoterRef> voters;

    @With
    @Value
    @AllArgsConstructor
    public static class CandidateId {
        private final UUID value;

        public static CandidateId id() {
            return new CandidateId(UUID.randomUUID());
        }

        public static CandidateId fromString(String uuidString) {
            return new CandidateId(UUID.fromString(uuidString));
        }

    }

    public Candidate(String name) {
        this(null, name, new CopyOnWriteArrayList<>());
    }

    public Candidate receiveVotes(Voter... voters) {
        return receiveVotes(Arrays.stream(voters).collect(toList()));
    }

    public Candidate receiveVotes(Iterable<Voter> iterableVoters) {
        requireNonNull(iterableVoters);
        StreamSupport.stream(iterableVoters.spliterator(), false)
                .map(Voter::getId)
                .map(VoterRef::of)
                .forEach(this.voters::add);
        return this;
    }

    @Override
    public int compareTo(Candidate other) {
        return Integer.compare(voters.size(), other.voters.size());
    }
    
}
