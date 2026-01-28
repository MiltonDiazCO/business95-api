package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.request.ActividadSocioRequest;
import com.business95.api.dto.request.MovimientoRequest;
import com.business95.api.dto.request.ActualizarMovimientoRequest;
import com.business95.api.dto.response.BalanceMovimientoResponse;
import com.business95.api.dto.response.BalanceSocioPorMovimientoResponse;
import com.business95.api.dto.response.MovimientoConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoResponse;
import com.business95.api.entity.ActividadSocio;
import com.business95.api.entity.Movimiento;
import com.business95.api.exception.MovimientoNoEncontradoException;
import com.business95.api.helper.ActividadSocioHelper;
import com.business95.api.helper.MovimientoHelper;
import com.business95.api.mapper.MovimientoMapper;
import com.business95.api.repository.MovimientoRepository;
import com.business95.api.service.interfaces.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

        private final MovimientoRepository movimientoRepository;
        private final MovimientoMapper movimientoMapper;
        private final MovimientoHelper movimientoHelper;
        private final ActividadSocioHelper actividadSocioHelper;

        public MovimientoServiceImpl(
                        MovimientoRepository movimientoRepository,
                        MovimientoMapper movimientoMapper,
                        MovimientoHelper movimientoHelper,
                        ActividadSocioHelper actividadSocioHelper) {
                this.movimientoRepository = movimientoRepository;
                this.movimientoMapper = movimientoMapper;
                this.movimientoHelper = movimientoHelper;
                this.actividadSocioHelper = actividadSocioHelper;
        }

        @Override
        @Transactional(readOnly = true)
        public MovimientoResponse movimientoPorId(Long idMovimiento) {
                return movimientoMapper.toMovimientoResponse(
                                movimientoHelper.buscarPorIdOLanzarExcepcion(idMovimiento));
        }

        @Override
        @Transactional(readOnly = true)
        public MovimientoConBalancesSociosResponse balanceSociosPorMovimiento(Long idMovimiento) {
                BalanceMovimientoResponse balanceMovimiento = movimientoRepository
                                .balanceMovimiento(idMovimiento)
                                .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento));

                MovimientoConBalancesSociosResponse movimientoResponse = movimientoMapper
                                .toMovimientoConBalancesSociosResponse(balanceMovimiento);

                List<BalanceSocioPorMovimientoResponse> balances = movimientoRepository
                                .balanceSocioPorMovimiento(idMovimiento);

                for (BalanceSocioPorMovimientoResponse balanceSocio : balances) {
                        movimientoResponse.addBalanceSocio(balanceSocio);
                }

                return movimientoResponse;
        }

        @Override
        @Transactional
        public MovimientoResponse guardar(MovimientoRequest movimientoRequest) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                null,
                                movimientoRequest.getInversion(),
                                movimientoRequest.getConcepto(),
                                movimientoRequest.getCategoria(),
                                movimientoRequest.getMedida(),
                                movimientoRequest.getMoneda());

                for (ActividadSocioRequest actividadSocioRequest : movimientoRequest.getActividades()) {

                        ActividadSocio actividadSocio = actividadSocioHelper.construirActividadSocio(
                                        actividadSocioRequest.getIdActividad(),
                                        actividadSocioRequest.getMonto(),
                                        actividadSocioRequest.getCantidad(),
                                        actividadSocioRequest.getFecha(),
                                        actividadSocioRequest.getSocio(),
                                        actividadSocioRequest.getTipoActividad());
                        movimiento.addActividadSocio(actividadSocio);
                }

                return movimientoMapper.toMovimientoResponse(movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public MovimientoResponse actualizar(
                        Long idMovimiento,
                        ActualizarMovimientoRequest actualizarMovimientoRequest) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                idMovimiento,
                                actualizarMovimientoRequest.getInversion(),
                                actualizarMovimientoRequest.getConcepto(),
                                actualizarMovimientoRequest.getCategoria(),
                                actualizarMovimientoRequest.getMedida(),
                                actualizarMovimientoRequest.getMoneda());

                return movimientoMapper.toMovimientoResponse(movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public void eliminar(Long idMovimiento) {
                movimientoRepository.delete(movimientoHelper.buscarPorIdOLanzarExcepcion(idMovimiento));
        }

}