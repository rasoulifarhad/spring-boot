package com.farhad.example.gamefification.academic.infrastructure.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.farhad.example.gamefification.academic.domain.model.CPF;
import com.farhad.example.gamefification.academic.domain.model.Student;
import com.farhad.example.gamefification.academic.domain.repository.StudentIndicationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentIndicationRepositoryInMemory  implements StudentIndicationRepository{

    private Map<CPF, Student> indications = new ConcurrentHashMap<>();

    @Override
    public void indicate(Student student) {
		log.info("indicating");

        indications.put(student.getCpf(), student);
    }

    @Override
    public Boolean itWasIndicated(CPF cpf) {
        return indications.containsKey(cpf);
    }
    
}
