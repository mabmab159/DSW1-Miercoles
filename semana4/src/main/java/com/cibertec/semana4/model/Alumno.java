package com.cibertec.semana4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AlumnoJPA2", indexes = {
        @Index(name="idx_nombre", columnList = "name"),
        @Index(name="idx_apellido", columnList = "apellido"),
        @Index(name="idx_nombre_apellido", columnList = "name,apellido")
})
//Indice -> Nombre y el apellido => 1 millon  => where apellido = '' and nombre = ''
public class Alumno {
    @Id
    private Long id; //Hashcode -> 1
    @Column(name = "name", nullable = false, length = 50) //Son para la tabla
    //@Size(min=50, max=50) //Validation -> DTO
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
}
