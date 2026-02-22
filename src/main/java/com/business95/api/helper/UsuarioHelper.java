package com.business95.api.helper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.business95.api.entity.Usuario;
import com.business95.api.exception.UsuarioNoEncontradoException;
import com.business95.api.repository.UsuarioRepository;

@Component
public class UsuarioHelper {

    UsuarioRepository usuarioRepository;
    PasswordEncoder passwordEncoder;

    public UsuarioHelper(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario construirUsuario(Long idSocio, String correoElectronico, String contrasena) {
        Usuario usuario = new Usuario();

        if (idSocio != null) {
            usuario = usuarioRepository.findBySocioIdSocio(idSocio)
                    .orElseThrow(() -> new UsuarioNoEncontradoException());
        }

        usuario.setCorreoElectronico(correoElectronico);

        if (contrasena != null) {
            usuario.setContrasena(passwordEncoder.encode(contrasena));
        }

        usuario.setHabilitado(true);

        return usuario;
    }

}
