package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.TipoPersona;
import com.business95.api.exception.TipoPersonaNoEncontradaException;
import com.business95.api.repository.TipoPersonaRepository;

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
