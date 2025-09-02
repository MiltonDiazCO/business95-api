package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.TipoPersona;
import com.business95.api.business95_api.exceptions.TipoPersonaNoEncontradaException;
import com.business95.api.business95_api.repositories.TipoPersonaRepository;

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
