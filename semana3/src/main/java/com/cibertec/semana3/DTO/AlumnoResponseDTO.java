package com.cibertec.semana3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private Integer version;
}
