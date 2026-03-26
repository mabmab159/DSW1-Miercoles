package com.cibertec.semana2.controller;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping("/all")
    public List<Alumno> getAllAlumnos(){
        return alumnoService.getAllAlumnos();
    }
}
