package com.cibertec.semana4.repository;

import com.cibertec.semana4.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findAllByOrderByApellidoDesc();

    //List<Alumno> findAllByOrderByApellidoDescfindAllByOrderByApellidoDesc();

    @Procedure(name = "sp_listarApellidos")
    List<Alumno> findAllByOrderByApellidoDesc2();

    @Query(value = "select a from Alumno a order by a.apellido DESC") //JPQL
    List<Alumno> findAllByOrderByApellidoDesc3();

    @Query(value = "select * from Alumno a ORDER BY a.apellido DESC",nativeQuery = true) //SQL - MySQL -> SQLServer
    List<Alumno> findAllByOrderByApellidoDesc4();
}
