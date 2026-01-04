package com.business95.api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.entities.Moneda;
import com.business95.api.exceptions.MonedaNoEncontradaException;
import com.business95.api.repositories.MonedaRepository;

@Component
public class MonedaHelper {

    private MonedaRepository monedaRepository;

    public MonedaHelper(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    public Moneda findByIdOrThrow(String idMoneda) {
        return monedaRepository.findById(idMoneda)
                .orElseThrow(() -> new MonedaNoEncontradaException(idMoneda));
    }

}
