package com.business95.api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.entities.TipoPersona;
import com.business95.api.exceptions.TipoPersonaNoEncontradaException;
import com.business95.api.repositories.TipoPersonaRepository;

@Component
public class TipoPersonaHelper {

    private TipoPersonaRepository tipoPersonaRepository;

    public TipoPersonaHelper(TipoPersonaRepository tipoPersonaRepository) {
        this.tipoPersonaRepository = tipoPersonaRepository;
    }

    public TipoPersona findByIdOrThrow(Long idTipoPersona) {
        return tipoPersonaRepository.findById(idTipoPersona)
                .orElseThrow(() -> new TipoPersonaNoEncontradaException(idTipoPersona));
    }

}
