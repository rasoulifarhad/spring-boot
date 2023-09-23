package com.farhad.example.election_layer.domain.candidate;

import java.util.UUID;

import javax.persistence.Table;

import lombok.Value;

@Table(name = "voter_ref")
@Value(staticConstructor = "of")
public class VoterRef {
    private final UUID voter;
}
