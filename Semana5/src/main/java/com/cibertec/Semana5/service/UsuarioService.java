package com.cibertec.Semana5.service;

import com.cibertec.Semana5.model.Usuario;
import com.cibertec.Semana5.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario login(String login, String password) {
        return usuarioRepository.findByUsernameAndPassword(login, password);
    }
}
