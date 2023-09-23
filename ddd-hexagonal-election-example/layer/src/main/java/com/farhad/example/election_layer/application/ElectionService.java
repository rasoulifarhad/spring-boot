package com.farhad.example.election_layer.application;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.farhad.example.election_layer.application.dto.CandidateDTO;
import com.farhad.example.election_layer.application.dto.ElectionDTO;
import com.farhad.example.election_layer.application.dto.VoterDTO;
import com.farhad.example.election_layer.domain.candidate.Candidate;
import com.farhad.example.election_layer.domain.candidate.CandidateRepository;
import com.farhad.example.election_layer.domain.election.Election;
import com.farhad.example.election_layer.domain.election.ElectionRepository;
import com.farhad.example.election_layer.domain.voter.Voter;
import com.farhad.example.election_layer.domain.voter.VoterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElectionService {
    
    private final VoterRepository voterRepository;
    private final ElectionRepository electionRepository;
    private final CandidateRepository candidateRepository;

    public Iterable<Election> getElections() {
        return electionRepository.findAll();
    }

    public Iterable<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public Iterable<Voter> getVoters() {
        return voterRepository.findAll();
    }

    public ElectionDTO beginElection(String name) {
        requireNonNull(name);
        Election election = new Election(name);
        election = electionRepository.save(election);
        return ElectionDTO.of(election);
    }

    public CandidateDTO registerCandidate(UUID electionId, String name){
        requireNonNull(electionId);
        requireNonNull(name);
        Election election = getElection(electionId);
        Candidate candidate = candidateRepository.save(new Candidate(name));
        Election updated = electionRepository.save(election.registerCandidates(candidate));
        log.info("registered candidate {} for election {}", candidate, updated);
        return CandidateDTO.of(candidate)        ;
    }

    public VoterDTO registerVoter(UUID electionId, String name){
        requireNonNull(electionId);
        requireNonNull(name);
        getElection(electionId);
        Voter voter = voterRepository.save(new Voter(name));
        return VoterDTO.of(voter);
    }

    public void vote(UUID electionId, UUID candidateId, UUID voterId) {
        requireNonNull(electionId);
        requireNonNull(candidateId);
        requireNonNull(voterId);
        Election election = getElection(electionId);
        Candidate candidate = candidateRepository.findById(candidateId)
                                                 .orElseThrow(() -> new IllegalArgumentException(
                                                         String.format("Candidate %s not found.", candidateId)));
        election.getCandidates().stream()
                    .filter(ref -> ref.getCondidate().equals(candidateId))
                    .findAny()
                    .orElseThrow(() -> 
                                new IllegalArgumentException(
                                            String.format(
                                                "Candidate %s is not register for election %s", 
                                                candidateId, 
                                                election)));
        Voter voter = voterRepository.findById(voterId)
                            .orElseThrow(() -> new IllegalArgumentException(
                                                    String.format("Voter %s not found.", voterId)));
        candidateRepository.save(candidate.receiveVotes(voter));
    }

    public List<String> getStatistics(UUID electionId) {
        requireNonNull(electionId);
        getElection(electionId);
        return candidateRepository.findStatistics(electionId)
                                    .stream()
                                    .map(s -> String.format("%s: %d", s.getName(), s.getTotalVotes()))
                                    .collect(toList());
    }

    private Election getElection(UUID electionId) {
        return electionRepository.findById(electionId)
                        .orElseThrow(() -> new IllegalArgumentException(
                            String.format("Election %s not found.", electionId)));
    }
}
