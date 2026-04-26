package com.cibertec.Semana5.controllers;

import com.cibertec.Semana5.model.Usuario;
import com.cibertec.Semana5.model.UsuarioLogin;
import com.cibertec.Semana5.security.JWTAuthenticationConfig;
import com.cibertec.Semana5.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final JWTAuthenticationConfig jwtAuthenticationConfig; //Genere el token
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> list = new ArrayList<>();
        list.add(new Usuario(1L, "miguel", "miguel", "miguel", "miguel", "miguel", "miguel", null));
        list.add(new Usuario(2L, "miguel2", "miguel", "miguel berrio", "miguel", "miguel", "miguel", null));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/unprotected")
    public ResponseEntity<List<Usuario>> getUnprotectedUsuarios() {
        List<Usuario> list = new ArrayList<>();
        list.add(new Usuario(1L, "miguel", "miguel", "miguel", "miguel", "miguel", "miguel", null));
        list.add(new Usuario(2L, "miguel2", "miguel", "miguel berrio", "miguel", "miguel", "miguel", null));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLogin usuarioLogin) {
        Usuario usuario = usuarioService.login(usuarioLogin.getUsuario(), usuarioLogin.getPassword());
        if (usuario == null) {
            throw new UsernameNotFoundException("Credenciales invalidas");
        }
        return ResponseEntity.ok(
                jwtAuthenticationConfig.getJWTToken(usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos())
        );
    }
}
