package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.business95.api.business95_api.dtos.requests.ActividadSocioRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.business95_api.dtos.responses.ActividadSocioResponse;
import com.business95.api.business95_api.dtos.responses.BalanceSocioResponse;
import com.business95.api.business95_api.dtos.responses.BalanceMovimientoResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoConBalancesResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoResponse;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.helpers.ActividadSocioHelper;
import com.business95.api.business95_api.helpers.MovimientoHelper;
import com.business95.api.business95_api.mappers.MovimientoMapper;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;

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

                Movimiento movimiento = movimientoHelper.findByIdOrThrow(idMovimiento);

                MovimientoResponse movimientoResponse = movimientoMapper.toMovimientoResponse(movimiento);

                List<ActividadSocioResponse> actividades = movimientoRepository.actividadesPorMovimiento(idMovimiento);

                for (ActividadSocioResponse actividadSocio : actividades) {
                        movimientoResponse.addActividadSocio(actividadSocio);
                }

                return movimientoResponse;
        }

        @Override
        @Transactional(readOnly = true)
        public MovimientoConBalancesResponse balanceSociosPorMovimiento(Long idMovimiento) {

                Movimiento movimiento = movimientoHelper.findByIdOrThrow(idMovimiento);

                MovimientoConBalancesResponse movimientoResponse = movimientoMapper
                                .toMovimientoConBalancesResponse(movimiento);

                List<BalanceSocioResponse> balancesSocios = movimientoRepository
                                .balanceSociosPorMovimiento(idMovimiento);

                for (BalanceSocioResponse balanceSocio : balancesSocios) {
                        movimientoResponse.addBalanceSocio(balanceSocio);
                }

                return movimientoResponse;
        }

        @Override
        @Transactional(readOnly = true)
        public List<BalanceMovimientoResponse> balanceMovimientosPorInversion(Long idInversion) {
                return movimientoRepository.balanceMovimientosPorInversion(idInversion);
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
        public DetalleMovimiento update(
                        Long idMovimiento,
                        MovimientoUpdateRequest movimientoUpdateRequest) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                idMovimiento,
                                movimientoUpdateRequest.getInversion(),
                                movimientoUpdateRequest.getConcepto(),
                                movimientoUpdateRequest.getCategoria(),
                                movimientoUpdateRequest.getMedida(),
                                movimientoUpdateRequest.getMoneda());

                return movimientoMapper.toDetalleMovimiento(movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public void delete(Long idMovimiento) {
                movimientoRepository.delete(movimientoHelper.findByIdOrThrow(idMovimiento));
        }

}