package com.business95.api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dtos.requests.ActividadSocioRequest;
import com.business95.api.dtos.requests.MovimientoRequest;
import com.business95.api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.dtos.responses.BalanceSocioPorMovRes;
import com.business95.api.dtos.responses.MovConBalancesSociosRes;
import com.business95.api.dtos.responses.MovimientoResponse;
import com.business95.api.entities.ActividadSocio;
import com.business95.api.entities.Movimiento;
import com.business95.api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.helpers.ActividadSocioHelper;
import com.business95.api.helpers.MovimientoHelper;
import com.business95.api.mappers.MovimientoMapper;
import com.business95.api.repositories.MovimientoRepository;
import com.business95.api.servicies.interfaces.MovimientoService;

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
                return movimientoMapper.toMovimientoResponse(movimientoHelper.findByIdOrThrow(idMovimiento));
        }

        @Override
        @Transactional(readOnly = true)
        public MovConBalancesSociosRes balanceSociosPorMovimiento(Long idMovimiento) {
                MovConBalancesSociosRes movResponse = movimientoRepository.balanceMovimiento(idMovimiento)
                                .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento));

                List<BalanceSocioPorMovRes> balances = movimientoRepository.balanceSocioPorMovimiento(idMovimiento);

                for (BalanceSocioPorMovRes balanceSocio : balances) {
                        movResponse.addBalanceSocio(balanceSocio);
                }

                return movResponse;
        }

        @Override
        @Transactional
        public MovimientoResponse save(MovimientoRequest movimientoRequest) {

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
        public MovimientoResponse update(
                        Long idMovimiento,
                        MovimientoUpdateRequest movimientoUpdateRequest) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                idMovimiento,
                                movimientoUpdateRequest.getInversion(),
                                movimientoUpdateRequest.getConcepto(),
                                movimientoUpdateRequest.getCategoria(),
                                movimientoUpdateRequest.getMedida(),
                                movimientoUpdateRequest.getMoneda());

                return movimientoMapper.toMovimientoResponse(movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public void delete(Long idMovimiento) {
                movimientoRepository.delete(movimientoHelper.findByIdOrThrow(idMovimiento));
        }

}