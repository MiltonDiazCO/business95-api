package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.repositories.MovimientoRepository;

@Component
public class MovimientoHelper {

    private final MovimientoRepository movimientoRepository;
    private final InversionHelper inversionHelper;
    private final CategoriaHelper categoriaHelper;
    private final MedidaHelper medidaHelper;
    private final MonedaHelper monedaHelper;

    public MovimientoHelper(
            MovimientoRepository movimientoRepository,
            InversionHelper inversionHelper,
            CategoriaHelper categoriaHelper,
            MedidaHelper medidaHelper,
            MonedaHelper monedaHelper) {
        this.movimientoRepository = movimientoRepository;
        this.inversionHelper = inversionHelper;
        this.categoriaHelper = categoriaHelper;
        this.medidaHelper = medidaHelper;
        this.monedaHelper = monedaHelper;
    }

    public Movimiento findByIdOrThrow(Long idMovimiento) {
        return movimientoRepository.findById(idMovimiento)
                .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento));
    }

    public Movimiento construirMovimiento(
            Long idMovimiento,
            Long idInversion,
            String concepto,
            Long idCategoria,
            Long idMedida,
            String idMoneda) {

        Movimiento movimiento = new Movimiento();

        if (idMovimiento != null) {
            movimiento = findByIdOrThrow(idMovimiento);
        }

        movimiento.setConcepto(concepto);
        movimiento.setInversion(inversionHelper.findByIdOrThrow(idInversion));
        movimiento.setCategoria(categoriaHelper.findByIdOrThrow(idCategoria));

        if (idMedida != null) {
            movimiento.setMedida(medidaHelper.findByIdOrThrow(idMedida));
        }

        if (idMoneda != null) {
            movimiento.setMoneda(monedaHelper.findByIdOrThrow(idMoneda));
        }

        return movimiento;
    }

}
