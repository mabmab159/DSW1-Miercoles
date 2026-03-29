package com.cibertec.semana2.controller;

import com.cibertec.semana2.model.Alumno;
import com.cibertec.semana2.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping("/all")
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        //return alumnoService.getAllAlumnos();
        //return ResponseEntity.status(200).body(alumnoService.getAllAlumnos());
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @PostMapping("/save")
    public ResponseEntity<Alumno> saveAlumno(@RequestBody @Valid Alumno alumno) {
        return ResponseEntity.status(201)
                .body(alumnoService.saveAlumno(alumno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.getAlumnoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody @Valid Alumno alumno) {
        return ResponseEntity.ok(alumnoService.updateAlumno(id, alumno));
    }
}
