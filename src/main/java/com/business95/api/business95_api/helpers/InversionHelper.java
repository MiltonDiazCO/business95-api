package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.repositories.InversionRepository;

@Component
public class InversionHelper {

    private InversionRepository inversionRepository;

    public InversionHelper(InversionRepository inversionRepository) {
        this.inversionRepository = inversionRepository;
    }

    public Inversion findByIdOrThrow(Long idInversion) {
        return inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

}
