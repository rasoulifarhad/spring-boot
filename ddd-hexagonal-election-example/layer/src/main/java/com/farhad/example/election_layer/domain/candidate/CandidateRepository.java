package com.farhad.example.election_layer.domain.candidate;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.farhad.example.election_layer.domain.candidate.Candidate.CandidateId;
import com.farhad.example.election_layer.domain.election.Election.ElectionId;

import lombok.Value;
import lombok.With;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {
    
    @With
    @Value
    class Statistic {
        private final String name;
        private final Long totalVotes;
    }

    @Query("  select   c.name          name,                     " +
            "          count(vr.voter) total_votes               " +
            " from     candidate       c                         " +
            " join     voter_ref       vr on c.id = vr.candidate " +
            " join     candidate_ref   cr on c.id = cr.candidate " +
            " join     election        e  on e.id = cr.election  " +
            " where                          e.id = :electionId  " +
            " group by c.name                                    " +
            " order by total_votes desc                          ")    
    List<Statistic> findStatistics(@Param("electionId") ElectionId electionId);
}
