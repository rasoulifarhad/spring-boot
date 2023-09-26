package com.farhad.example.gamefification.academic.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "cpf")
@Builder
@Getter
@Generated
public class Student {
    private final CPF cpf;
    private final String name;
}
