package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Medida;
import com.business95.api.exception.MedidaNoEncontradaException;
import com.business95.api.repository.MedidaRepository;

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
