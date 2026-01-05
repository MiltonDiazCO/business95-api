package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Moneda;
import com.business95.api.exception.MonedaNoEncontradaException;
import com.business95.api.repository.MonedaRepository;

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
