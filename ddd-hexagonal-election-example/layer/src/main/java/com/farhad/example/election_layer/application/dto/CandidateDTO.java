package com.farhad.example.election_layer.application.dto;

import java.util.UUID;

import com.farhad.example.election_layer.domain.candidate.Candidate;

import lombok.Value;

@Value
public class CandidateDTO {

    private final UUID id;
    private final String name;

    public static CandidateDTO of(Candidate candidate) {
        return new CandidateDTO(candidate.getId(), candidate.getName());
    }
}