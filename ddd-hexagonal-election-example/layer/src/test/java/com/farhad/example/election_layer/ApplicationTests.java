package com.farhad.example.election_layer;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.election_layer.domain.candidate.Candidate;
import com.farhad.example.election_layer.domain.candidate.CandidateRepository;
import com.farhad.example.election_layer.domain.voter.Voter;
import com.farhad.example.election_layer.domain.voter.VoterRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@AllArgsConstructor(onConstructor_ = @Autowired)
class ApplicationTests {

    VoterRepository voterRepository;
    CandidateRepository candidateRepository;

	@Test
	void contextLoads() {
	}


    @Test
    void should_save_all_voters() {
        Iterable<Voter> voters = voterRepository.saveAll(Arrays.asList(
                new Voter("Voter 1"),
                new Voter("Voter 2"),
                new Voter("Voter 3")
        ));
        log.info(voters);
    }

    @Test
    void should_save_all_candidates() {
        Iterable<Candidate> candidates = candidateRepository.saveAll(Arrays.asList(
                new Candidate("Candidate 1"),
                new Candidate("Candidate 2")
        ));
        log.info(candidates);
    }

    @Test
    void should_save_candidate_with_voters() {
        Candidate candidate = new Candidate("Candidate 1");
        candidateRepository.save(candidate);
        log.info("candidate: {}", candidate);

        Iterable<Voter> voters = voterRepository.saveAll(Arrays.asList(
                new Voter("Voter 1"),
                new Voter("Voter 2"),
                new Voter("Voter 3")
        ));
        log.info("voters: {}", voters);

        candidateRepository.save(candidate.receiveVotes(voters));
        for (Candidate c : candidateRepository.findAll()) {
            log.info("after voted: {}", c);
        }
    }	
}
