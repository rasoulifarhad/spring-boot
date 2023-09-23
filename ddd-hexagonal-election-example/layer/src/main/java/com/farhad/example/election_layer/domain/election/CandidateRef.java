package com.farhad.example.election_layer.domain.election;

import java.util.UUID;

import javax.persistence.Table;

import lombok.Value;

@Table(name = "condidate_ref")
@Value(staticConstructor = "of")
public class CandidateRef {
    private final UUID condidate;
}
