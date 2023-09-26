package com.farhad.example.gamefification.academic.application.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.farhad.example.gamefification.academic.domain.model.CPF;
import com.farhad.example.gamefification.academic.domain.model.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Valid
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDto {

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String name;

    public Student student() {
        return Student.builder()
                    .name(name)
                    .cpf(new CPF(cpf))
                    .build();
    }
}
