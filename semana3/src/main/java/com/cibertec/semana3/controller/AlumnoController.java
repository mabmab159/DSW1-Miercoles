package com.cibertec.semana3.controller;

import com.cibertec.semana3.DTO.AlumnoRequestDTO;
import com.cibertec.semana3.DTO.AlumnoResponseDTO;
import com.cibertec.semana3.model.Alumno;
import com.cibertec.semana3.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<AlumnoResponseDTO> createAlumno(@RequestBody @Valid AlumnoRequestDTO alumnoRequestDTO){
        return ResponseEntity.status(201).body(alumnoService.createAlumno(alumnoRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> updateAlumno(@PathVariable Long id,  @RequestBody @Valid AlumnoRequestDTO alumnoRequestDTO){
        return ResponseEntity.ok(alumnoService.updateAlumno(id, alumnoRequestDTO));
    }

}
