package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.business95_api.dtos.responses.ActividadSocioResponse;
import com.business95.api.business95_api.dtos.responses.BalanceSocioResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoPorInversionResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoConBalancesSociosResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoUpdateResponse;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.helpers.ActividadSocioHelper;
import com.business95.api.business95_api.helpers.MovimientoHelper;
import com.business95.api.business95_api.mappers.MovimientoMapper;
import com.business95.api.business95_api.projections.BalanceSocioPorMovimientoProjection;
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
        public MovimientoConBalancesSociosResponse balanceSociosPorMovimiento(Long idMovimiento) {

                movimientoHelper.findByIdOrThrow(idMovimiento);

                List<BalanceSocioPorMovimientoProjection> balancesSocios = movimientoRepository.balanceSocioPorMovimiento(idMovimiento);

                System.out.println(movimientoRepository.balanceSocioPorMovimiento(idMovimiento).get(0).getIdMovimiento());

                MovimientoConBalancesSociosResponse movimientoConBalances = movimientoHelper.construirDetalleMovimiento(
                                balancesSocios.get(0).getIdMovimiento(),
                                balancesSocios.get(0).getInversion(),
                                balancesSocios.get(0).getConcepto(),
                                balancesSocios.get(0).getCategoria(),
                                balancesSocios.get(0).getMedida(),
                                balancesSocios.get(0).getMoneda(),
                                MovimientoConBalancesSociosResponse::new);

                for (BalanceSocioPorMovimientoProjection balanceSocio : balancesSocios) {
                        BalanceSocioResponse balanceSocioResponse = new BalanceSocioResponse();
                        balanceSocioResponse.setSocio(balanceSocio.getSocio());
                        balanceSocioResponse.setCantidad(balanceSocio.getCantidad());
                        balanceSocioResponse.setBalanceMonetario(balanceSocio.getBalanceMonetario());
                        movimientoConBalances.addBalanceSocio(balanceSocioResponse);
                }

                return movimientoConBalances;
        }

        @Override
        @Transactional(readOnly = true)
        public List<MovimientoPorInversionResponseDTO> findMovimientosPorInversion(Long idInversion) {

                System.out.println(movimientoRepository.movimientoPorInversion(idInversion).size());

                return movimientoRepository.movimientoPorInversion(idInversion).stream()
                                .map(movimientoMapper::movimientoPorInversionProjectionTOMovimientoPorInversionResponseDTO)
                                .toList();
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
        public MovimientoUpdateResponse update(
                        Long idMovimiento,
                        MovimientoUpdateRequest movimientoUpdateRequest) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                idMovimiento,
                                movimientoUpdateRequest.getInversion(),
                                movimientoUpdateRequest.getConcepto(),
                                movimientoUpdateRequest.getCategoria(),
                                movimientoUpdateRequest.getMedida(),
                                movimientoUpdateRequest.getMoneda());

                return movimientoMapper.tOMovimientoUpdateResponse(movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public void delete(Long idMovimiento) {
                movimientoRepository.delete(movimientoHelper.findByIdOrThrow(idMovimiento));
        }

};