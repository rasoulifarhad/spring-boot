package com.farhad.example.gamefification.academic.domain.repository;

import com.farhad.example.gamefification.academic.domain.model.CPF;
import com.farhad.example.gamefification.academic.domain.model.Student;

public interface StudentIndicationRepository {
    void indicate(Student student);
    Boolean itWasIndicated(CPF cpf);
}
