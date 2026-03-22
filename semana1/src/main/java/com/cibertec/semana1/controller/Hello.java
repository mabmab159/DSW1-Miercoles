package com.cibertec.semana1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //Es una interfaz que nos permite crear un controlador | Expone un APIREST - JSON
public class Hello {

    @GetMapping("/hello") //Es una interfaz que nos permite exponer un metodo - GET
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public List<String> hello2() {
        return List.of("Hola", "Amigos", "Cibertec");
    }

    @GetMapping("/hello3")
    public List<String> hello3() {
        List<String> nombres = List.of("Ignacio", "Rafael", "Otar");
        // Hola Ignacio, Hola Rafael, Hola Otar
        /*List<String> resultado = new ArrayList<>();
        for (String nombre : nombres) {
            resultado.add("Hola " + nombre);
        }
        return resultado;*/
        return nombres.stream() //Flujo de datos
                .map(nombre -> "Hola " + nombre) // Transforma cada elemento del flujo | Retorna los datps
                .toList(); // Convierte el flujo -> List<>
    }

    @GetMapping("/hello4")
    public String hello4() { //Estas creando 3 Objetos
        String saludo = "Hola "; // Estas creando un Objeto | StringPool
        String nombre = "Ignacio"; // Estas creando un Objeto | StringPool
        return saludo + nombre; //Hola Ignacio | Estas creando un Objeto | StringPool
    }

    @GetMapping("/hello5")
    public String hello5() { //He creado 1 Objeto
        StringBuilder saludo = new StringBuilder("Hola "); //Esta creando un Objeto
        return saludo.append("Ignacio").toString(); //Añade este valor
    }

    @PostMapping("/enviarDatos") //El navegador por defecto solo utiliza GET
    public String enviarDatos() {
        return "Datos enviados";
    }

    @GetMapping("/hello6/{valor}/{valor2}")
    public String hello6(@PathVariable("valor") String valor1, @PathVariable String valor2) {
        return valor1 + " " + valor2;
    }

    @GetMapping("/hello7")
    public String hello7(@RequestParam("valor") String nombre, @RequestParam("valor2") String apellido) {
        return nombre + " " + apellido;
    }

    @GetMapping("/hello8")
    public List<String> hello8(@RequestParam("valor") String nombre) {
        List<String> nombres = List.of("Ignacio", "Rafael", "Otar");
        // o -> Otar
        // I -> Ignacio
        // S -> []
        List<String> resultado = new ArrayList<>();
        for (String n : nombres) {
            if (n.toLowerCase().startsWith(nombre.toLowerCase())) {
                resultado.add(n);
            }
        }
        // return nombres.stream().filter(e -> e.startsWith(nombre.toLowerCase())).toList();
        return resultado;
    }
}
