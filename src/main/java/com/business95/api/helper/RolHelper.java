package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Rol;
import com.business95.api.exception.RolNoEncontradoException;
import com.business95.api.repository.RolRepository;

@Component
public class RolHelper {

    private RolRepository rolRepository;

    public RolHelper(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol buscarPorRolOLanzarExcepcion(String rol) {
        return rolRepository.findByRol(rol)
                .orElseThrow(() -> new RolNoEncontradoException(rol));
    }

}
