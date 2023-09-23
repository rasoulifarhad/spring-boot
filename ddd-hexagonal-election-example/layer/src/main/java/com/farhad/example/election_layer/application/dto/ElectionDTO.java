package com.farhad.example.election_layer.application.dto;

import java.util.UUID;

import com.farhad.example.election_layer.domain.election.Election;

import lombok.Value;

@Value
public class ElectionDTO {
    
    private final UUID id;
    private final String name;

    public static ElectionDTO of(Election election) {
        return new ElectionDTO(election.getId(), election.getName());
    }
}
