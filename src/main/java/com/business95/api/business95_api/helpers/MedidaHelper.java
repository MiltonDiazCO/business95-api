package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.Medida;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.repositories.MedidaRepository;

@Component
public class MedidaHelper {

    private MedidaRepository medidaRepository;

    public MedidaHelper(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    public Medida findByIdOrThrow(Long idMedida) {
        return medidaRepository.findById(idMedida)
                .orElseThrow(() -> new MedidaNoEncontradaException(idMedida));
    }

}
