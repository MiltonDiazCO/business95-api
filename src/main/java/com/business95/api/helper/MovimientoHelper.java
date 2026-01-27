package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Movimiento;
import com.business95.api.exception.MovimientoNoEncontradoException;
import com.business95.api.repository.MovimientoRepository;

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

    public Movimiento buscarPorIdOLanzarExcepcion(Long idMovimiento) {
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
            movimiento = buscarPorIdOLanzarExcepcion(idMovimiento);
        }

        movimiento.setConcepto(concepto);
        movimiento.setInversion(inversionHelper.buscarPorIdOLanzarExcepcion(idInversion));
        movimiento.setCategoria(categoriaHelper.buscarPorIdOLanzarExcepcion(idCategoria));

        if (idMedida != null) {
            movimiento.setMedida(medidaHelper.buscarPorIdOLanzarExcepcion(idMedida));
        }

        if (idMoneda != null) {
            movimiento.setMoneda(monedaHelper.buscarPorIdOLanzarExcepcion(idMoneda));
        }

        return movimiento;
    }

}
