package com.cibertec.semana2.service;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno getAlumnoById(Long id) {
        /*Optional<Alumno> alumno = alumnoRepository.findById(id);
        if(alumno.isPresent()){
            return alumno.get();
        }
        return null;*/
        return alumnoRepository.getReferenceById(id);
    }

    public Alumno updateAlumno(Long id, Alumno alumno){
        Optional<Alumno> alumnoObtenido = alumnoRepository.findById(id);
        if(alumnoObtenido.isPresent()){
            //Actualizar
            alumno.setId(id);
        }else{
            //Guardar
            alumno.setId(null);
        }
        return alumnoRepository.save(alumno);
    }
}
