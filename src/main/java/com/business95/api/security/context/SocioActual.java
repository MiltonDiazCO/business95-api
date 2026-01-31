package com.business95.api.security.context;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.business95.api.repository.SocioRepository;

@Component
public class SocioActual {

    private final SocioRepository socioRepository;

    public SocioActual(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public Long getIdSocioActual() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        return socioRepository.buscarIdSocioPorCorreoElectronico(auth.getName());
    }

}
