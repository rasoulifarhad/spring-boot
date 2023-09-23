package com.farhad.example.election_layer.domain.candidate;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lombok.Value;
import lombok.With;

public interface CandidateRepository extends CrudRepository<Candidate, UUID> {
    
    @With
    @Value
    class Statistic {
        private final String name;
        private final Long totalVotes;
    }

    @Query(

    )
    List<Statistic> findStatistics(@Param("electionId") UUID electionId);
}
