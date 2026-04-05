package com.cibertec.semana3.service;

import com.cibertec.semana3.DTO.AlumnoRequestDTO;
import com.cibertec.semana3.DTO.AlumnoResponseDTO;
import com.cibertec.semana3.model.Alumno;
import com.cibertec.semana3.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final ObjectMapper objectMapper;

    public AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO){
        //DTO -> Model
        var modeloAlumno = objectMapper.convertValue(alumnoRequestDTO, Alumno.class); //var en java 17 - Alumno
        // var js // var titulo1 = 1 // var titulo1 = "Miguel"
        // var en Java // var(int) titulo1 = 1 // var titulo1 = "Miguel" X
        //Guardar el modelo apuntando al repository -> Model
        var responseModel = alumnoRepository.save(modeloAlumno);
        //Model -> DTO
        return objectMapper.convertValue(responseModel, AlumnoResponseDTO.class);
    }

    public AlumnoResponseDTO updateAlumno(Long id, AlumnoRequestDTO alumnoRequestDTO){
        var modeloAlumno = objectMapper.convertValue(alumnoRequestDTO, Alumno.class);
        modeloAlumno.setId(id);
        var responseModel = alumnoRepository.save(modeloAlumno);
        return objectMapper.convertValue(responseModel, AlumnoResponseDTO.class);
    }
}
