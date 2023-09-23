package com.farhad.example.election_layer.domain.candidate;

import javax.persistence.Table;

import com.farhad.example.election_layer.domain.voter.Voter.VoterId;

import lombok.Value;

@Table(name = "voter_ref")
@Value(staticConstructor = "of")
public class VoterRef {
    private final VoterId voter;
}
