package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.repositories.CategoriaRepository;
import com.business95.api.business95_api.repositories.MonedaRepository;
import com.business95.api.business95_api.repositories.MedidaRepository;

@Component
public class MovimientoHelper {

    private final InversionRepository inversionRepository;
    private final CategoriaRepository categoriaRepository;
    private final MedidaRepository medidaRepository;
    private final MonedaRepository monedaRepository;

    public MovimientoHelper(
            InversionRepository inversionRepository,
            CategoriaRepository categoriaRepository,
            MedidaRepository medidaRepository,
            MonedaRepository monedaRepository) {
        this.inversionRepository = inversionRepository;
        this.categoriaRepository = categoriaRepository;
        this.medidaRepository = medidaRepository;
        this.monedaRepository = monedaRepository;
    }

    public Movimiento construirMovimiento(
            Long idInversion,
            String concepto,
            Long idCategoria,
            Long idMedida,
            String idMoneda) {
        
        Movimiento movimiento = new Movimiento();
        
        movimiento.setConcepto(concepto);

        movimiento.setInversion(inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion)));

        movimiento.setCategoria(categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new CategoriaNoEncontradaException(idCategoria)));

        if (idMedida != null) {
            movimiento.setMedida(medidaRepository.findById(idMedida)
                    .orElseThrow(() -> new MedidaNoEncontradaException(idMedida)));
        }

        if (idMoneda != null) {
            movimiento.setMoneda(monedaRepository.findById(idMoneda)
                    .orElseThrow(() -> new MonedaNoEncontradaException(idMoneda)));
        }

        return movimiento;
    }
}
