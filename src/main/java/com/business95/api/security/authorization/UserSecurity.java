package com.business95.api.security.authorization;

import org.springframework.stereotype.Component;

import com.business95.api.repository.SocioRepository;

@Component("userSecurity")
public class UserSecurity {

    private SocioRepository socioRepository;

    public UserSecurity(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public boolean esDueño(Long idSocio, String correoDelToken) {
        return socioRepository.findById(idSocio)
                .map(socio -> socio.getUsuario().getCorreoElectronico().equals(correoDelToken))
                .orElse(false);
    }

}
