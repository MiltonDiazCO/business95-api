package com.business95.api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.entities.Medida;
import com.business95.api.exceptions.MedidaNoEncontradaException;
import com.business95.api.repositories.MedidaRepository;

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
