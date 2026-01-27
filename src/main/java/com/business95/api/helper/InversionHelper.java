package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Inversion;
import com.business95.api.exception.InversionNoEncontradaException;
import com.business95.api.repository.InversionRepository;

@Component
public class InversionHelper {

    private InversionRepository inversionRepository;

    public InversionHelper(InversionRepository inversionRepository) {
        this.inversionRepository = inversionRepository;
    }

    public Inversion buscarPorIdOLanzarExcepcion(Long idInversion) {
        return inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

}
