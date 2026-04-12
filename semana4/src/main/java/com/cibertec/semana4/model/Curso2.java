package com.cibertec.semana4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Curso2JPA2")
public class Curso2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int aforo;
    private int ciclo;
}
