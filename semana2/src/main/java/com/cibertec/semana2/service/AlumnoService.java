package com.cibertec.semana2.service;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos(){
        return alumnoRepository.findAll();
    }
}
