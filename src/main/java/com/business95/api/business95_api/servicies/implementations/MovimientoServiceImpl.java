package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.projections.BalanceSocioPorMovimientoConsultaDTO;
import com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO;
import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequestDTO;
import com.business95.api.business95_api.dtos.responses.BalanceSocioResponseDTO;
import com.business95.api.business95_api.dtos.responses.BalanceSocioPorMovimientoResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoUpdateResponseDTO;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.helpers.ActividadSocioHelper;
import com.business95.api.business95_api.helpers.MovimientoHelper;
import com.business95.api.business95_api.mappers.ActividadSocioMapper;
import com.business95.api.business95_api.mappers.MovimientoMapper;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

        private final MovimientoRepository movimientoRepository;
        private final MovimientoMapper movimientoMapper;
        private final ActividadSocioMapper actividadSocioMapper;
        private final MovimientoHelper movimientoHelper;
        private final ActividadSocioHelper actividadSocioHelper;

        public MovimientoServiceImpl(
                        MovimientoRepository movimientoRepository,
                        MovimientoMapper movimientoMapper,
                        ActividadSocioMapper actividadSocioMapper,
                        MovimientoHelper movimientoHelper,
                        ActividadSocioHelper actividadSocioHelper) {
                this.movimientoRepository = movimientoRepository;
                this.movimientoMapper = movimientoMapper;
                this.actividadSocioMapper = actividadSocioMapper;
                this.movimientoHelper = movimientoHelper;
                this.actividadSocioHelper = actividadSocioHelper;
        }

        @Override
        @Transactional(readOnly = true)
        public MovimientoResponseDTO movimientoPorId(Long idMovimiento) {

                List<MovimientoConsultaDTO> consultaDTO = movimientoRepository.movimientoPorId(idMovimiento);

                if (consultaDTO.isEmpty()) {
                        throw new MovimientoNoEncontradoException(idMovimiento);
                }

                MovimientoResponseDTO responseDTO = movimientoHelper.construirDetalleMovimiento(
                                consultaDTO.get(0).getIdMovimiento(),
                                consultaDTO.get(0).getInversion(),
                                consultaDTO.get(0).getConcepto(),
                                consultaDTO.get(0).getCategoria(),
                                consultaDTO.get(0).getMedida(),
                                consultaDTO.get(0).getMoneda(),
                                MovimientoResponseDTO::new);

                for (MovimientoConsultaDTO movimientoConsultaDTO : consultaDTO) {
                        responseDTO.addActividadSocio(actividadSocioMapper
                                .movimientoConsultaDtoToActividadSocioResponseDTO(movimientoConsultaDTO));
                }

                return responseDTO;
        }

        @Override
        @Transactional(readOnly = true)
        public BalanceSocioPorMovimientoResponseDTO balanceSociosPorMovimiento(Long idMovimiento) {

                List<BalanceSocioPorMovimientoConsultaDTO> consultaDTO = movimientoRepository
                                .balanceSocioPorMovimiento(idMovimiento);

                if (consultaDTO.isEmpty()) {
                        throw new MovimientoNoEncontradoException(idMovimiento);
                }

                BalanceSocioPorMovimientoResponseDTO responseDTO = movimientoHelper.construirDetalleMovimiento(
                                consultaDTO.get(0).getIdMovimiento(),
                                consultaDTO.get(0).getInversion(),
                                consultaDTO.get(0).getConcepto(),
                                consultaDTO.get(0).getCategoria(),
                                consultaDTO.get(0).getMedida(),
                                consultaDTO.get(0).getMoneda(),
                                BalanceSocioPorMovimientoResponseDTO::new);

                for (BalanceSocioPorMovimientoConsultaDTO balanceSocio : consultaDTO) {
                        BalanceSocioResponseDTO balanceSocioResponseDTO = new BalanceSocioResponseDTO();
                        balanceSocioResponseDTO.setSocio(balanceSocio.getSocio());
                        balanceSocioResponseDTO.setCantidad(balanceSocio.getCantidad());
                        balanceSocioResponseDTO.setBalanceMonetario(balanceSocio.getBalanceMonetario());
                        responseDTO.addBalanceSocio(balanceSocioResponseDTO);
                }

                return responseDTO;
        }

        @Override
        @Transactional
        public MovimientoResponseDTO save(MovimientoRequestDTO movimientoRequestDTO) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                null,
                                movimientoRequestDTO.getInversion(),
                                movimientoRequestDTO.getConcepto(),
                                movimientoRequestDTO.getCategoria(),
                                movimientoRequestDTO.getMedida(),
                                movimientoRequestDTO.getMoneda());

                for (ActividadSocioRequestDTO actividadSocioRequestDTO : movimientoRequestDTO.getActividades()) {

                        ActividadSocio actividadSocio = actividadSocioHelper.construirActividadSocio(
                                        actividadSocioRequestDTO.getIdActividad(),
                                        actividadSocioRequestDTO.getMonto(),
                                        actividadSocioRequestDTO.getCantidad(),
                                        actividadSocioRequestDTO.getFecha(),
                                        actividadSocioRequestDTO.getSocio(),
                                        actividadSocioRequestDTO.getTipoActividad());
                        movimiento.addActividadSocio(actividadSocio);
                }

                return movimientoMapper.movimientoToMovimientoResponseDTO(
                                movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public MovimientoUpdateResponseDTO update(
                        Long idMovimiento,
                        MovimientoUpdateRequestDTO movimientoUpdateRequestDTO) {

                Movimiento movimiento = movimientoHelper.construirMovimiento(
                                idMovimiento,
                                movimientoUpdateRequestDTO.getInversion(),
                                movimientoUpdateRequestDTO.getConcepto(),
                                movimientoUpdateRequestDTO.getCategoria(),
                                movimientoUpdateRequestDTO.getMedida(),
                                movimientoUpdateRequestDTO.getMoneda());

                return movimientoMapper.movimientoToMovimientoUpdateResponseDTO(
                        movimientoRepository.save(movimiento));
        }

        @Override
        @Transactional()
        public void delete(Long idMovimiento) {
                movimientoRepository.delete(movimientoRepository.findById(idMovimiento)
                        .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento)));
        }

};