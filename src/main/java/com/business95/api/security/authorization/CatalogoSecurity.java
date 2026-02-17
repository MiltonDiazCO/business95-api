package com.business95.api.security.authorization;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.business95.api.repository.PermisoRepository;
import com.business95.api.repository.UsuarioRepository;
import com.business95.api.security.context.SocioActual;

@Component("catalogoSecurity")
public class CatalogoSecurity {

    private final SocioActual socioActual;
    private final UsuarioRepository usuarioRepository;
    private final PermisoRepository permisoRepository;

    public CatalogoSecurity(
            SocioActual socioActual,
            UsuarioRepository usuarioRepository,
            PermisoRepository permisoRepository) {
        this.socioActual = socioActual;
        this.usuarioRepository = usuarioRepository;
        this.permisoRepository = permisoRepository;
    }

    public boolean tienePermiso(String permiso) {
        Set<String> roles = usuarioRepository.findById(socioActual.getIdSocioActual())
                .get().getRoles()
                .stream().map((rol) -> rol.getRol()).collect(Collectors.toSet());

        for (String rol : roles) {
            if (permisoRepository.buscarPorRolYPermiso(rol, permiso).isPresent()) {
                return true;
            }
        }

        return false;
    }

}
