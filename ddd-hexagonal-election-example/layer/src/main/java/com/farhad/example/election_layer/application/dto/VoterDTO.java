package com.farhad.example.election_layer.application.dto;

import java.util.UUID;

import com.farhad.example.election_layer.domain.voter.Voter;

import lombok.Value;

@Value
public class VoterDTO {
    
    private final UUID id;
    private final String name;

    public static VoterDTO of(Voter voter) {
        return new VoterDTO(voter.getId().getValue(), voter.getName());
    }    
}
