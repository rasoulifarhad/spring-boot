package com.farhad.example.election_layer.domain.election;

import javax.persistence.Table;

import com.farhad.example.election_layer.domain.candidate.Candidate.CandidateId;

import lombok.Value;

@Table(name = "condidate_ref")
@Value(staticConstructor = "of")
public class CandidateRef {
    private final CandidateId condidate;
}
