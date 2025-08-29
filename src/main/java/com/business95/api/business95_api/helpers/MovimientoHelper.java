package com.business95.api.business95_api.helpers;

import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.repositories.CategoriaRepository;
import com.business95.api.business95_api.repositories.MonedaRepository;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.repositories.MedidaRepository;

@Component
public class MovimientoHelper {

    private final MovimientoRepository movimientoRepository;
    private final InversionRepository inversionRepository;
    private final CategoriaRepository categoriaRepository;
    private final MedidaRepository medidaRepository;
    private final MonedaRepository monedaRepository;

    public MovimientoHelper(
            MovimientoRepository movimientoRepository,
            InversionRepository inversionRepository,
            CategoriaRepository categoriaRepository,
            MedidaRepository medidaRepository,
            MonedaRepository monedaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.inversionRepository = inversionRepository;
        this.categoriaRepository = categoriaRepository;
        this.medidaRepository = medidaRepository;
        this.monedaRepository = monedaRepository;
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

    public <T extends DetalleMovimiento> T construirDetalleMovimiento(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            Supplier<T> constructor) {

        T detalleMovimiento = constructor.get();

        detalleMovimiento.setIdMovimiento(idMovimiento);
        detalleMovimiento.setInversion(inversion);
        detalleMovimiento.setConcepto(concepto);
        detalleMovimiento.setCategoria(categoria);
        detalleMovimiento.setMedida(medida);
        detalleMovimiento.setMoneda(moneda);

        return detalleMovimiento;
    }

}
