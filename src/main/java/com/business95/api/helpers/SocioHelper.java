package com.business95.api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.entities.Socio;
import com.business95.api.exceptions.SocioNoEncontradoException;
import com.business95.api.repositories.SocioRepository;

@Component
public class SocioHelper {

    private SocioRepository socioRepository;

    public SocioHelper(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public Socio findByIdOrThrow(Long idSocio) {
        return socioRepository.findById(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));
    }

}
