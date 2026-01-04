package com.business95.api.servicies.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.entities.Usuario;
import com.business95.api.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreoElectronico(correoElectronico);

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado!");
        }

        Usuario usuario = usuarioOptional.orElseThrow();

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRol())).collect(Collectors.toList());

        return new User(
                usuario.getCorreoElectronico(),
                usuario.getContrasena(),
                usuario.getHabilitado(),
                true,
                true,
                true,
                authorities);
    }

}
