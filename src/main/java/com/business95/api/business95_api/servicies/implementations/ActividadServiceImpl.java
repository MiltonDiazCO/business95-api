package com.business95.api.business95_api.servicies.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;
import com.business95.api.business95_api.dtos.responses.ActividadSocioResponseDTO;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.ActividadSocioNoEncontradaException;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.helpers.ActividadSocioHelper;
import com.business95.api.business95_api.mappers.ActividadSocioMapper;
import com.business95.api.business95_api.repositories.ActividadSocioRepository;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.servicies.interfaces.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService {

        @Autowired
        private ActividadSocioRepository actividadSocioRepository;

        @Autowired
        private MovimientoRepository movimientoRepository;

        @Autowired
        private ActividadSocioMapper actividadSocioMapper;

        @Autowired
        private ActividadSocioHelper actividadSocioHelper;

        @Override
        @Transactional()
        public List<ActividadSocioResponseDTO> save(
                        Long idMovimiento,
                        List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs) {

                Movimiento movimiento = movimientoRepository.findById(idMovimiento)
                                .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento));

                List<ActividadSocio> nuevasActividades = new ArrayList<>();

                for (ActividadSocioRequestDTO actividadSocioRequestDTO : actividadesSocioRequestDTOs) {

                        ActividadSocio actividadSocio = actividadSocioHelper.construirActividadSocio(
                                        actividadSocioRequestDTO.getIdActividad(),
                                        actividadSocioRequestDTO.getMonto(),
                                        actividadSocioRequestDTO.getCantidad(),
                                        actividadSocioRequestDTO.getFecha(),
                                        actividadSocioRequestDTO.getSocio(),
                                        actividadSocioRequestDTO.getTipoActividad());

                        movimiento.addActividadSocio(actividadSocio);
                        actividadSocioRepository.save(actividadSocio);
                        nuevasActividades.add(actividadSocio);
                }

                movimientoRepository.save(movimiento);

                return nuevasActividades.stream()
                                .map(actividadSocioMapper::actividadSocioToActividadSocioResponseDTO)
                                .toList();
        }

        @Override
        @Transactional()
        public void delete(Long idMovimiento, ArrayList<Long> idActividades) {

                Movimiento movimiento = movimientoRepository.findById(idMovimiento)
                                .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento));

                for (Long idActividad : idActividades) {
                        movimiento.removeActividadSocio(actividadSocioRepository.findById(idActividad)
                                        .orElseThrow(() -> new ActividadSocioNoEncontradaException(idActividad)));
                }

                movimientoRepository.save(movimiento);
        }

}
