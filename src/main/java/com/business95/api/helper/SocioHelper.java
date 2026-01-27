package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Socio;
import com.business95.api.exception.SocioNoEncontradoException;
import com.business95.api.repository.SocioRepository;

@Component
public class SocioHelper {

    private SocioRepository socioRepository;

    public SocioHelper(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public Socio buscarPorIdOLanzarExcepcion(Long idSocio) {
        return socioRepository.findById(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));
    }

}
