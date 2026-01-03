package com.business95.api.business95_api.servicies.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequest;
import com.business95.api.business95_api.dtos.responses.ActividadSocioResponse;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.helpers.ActividadSocioHelper;
import com.business95.api.business95_api.helpers.MovimientoHelper;
import com.business95.api.business95_api.mappers.ActividadSocioMapper;
import com.business95.api.business95_api.repositories.ActividadSocioRepository;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.servicies.interfaces.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService {

        private final ActividadSocioRepository actividadSocioRepository;
        private final MovimientoRepository movimientoRepository;
        private final ActividadSocioHelper actividadSocioHelper;
        private final MovimientoHelper movimientoHelper;
        private final ActividadSocioMapper actividadSocioMapper;

        public ActividadServiceImpl(
                        ActividadSocioRepository actividadSocioRepository,
                        MovimientoRepository movimientoRepository,
                        ActividadSocioHelper actividadSocioHelper,
                        MovimientoHelper movimientoHelper,
                        ActividadSocioMapper actividadSocioMapper) {
                this.actividadSocioRepository = actividadSocioRepository;
                this.movimientoRepository = movimientoRepository;
                this.actividadSocioHelper = actividadSocioHelper;
                this.movimientoHelper = movimientoHelper;
                this.actividadSocioMapper = actividadSocioMapper;
        }

        @Override
        @Transactional()
        public List<ActividadSocioResponse> save(
                        Long idMovimiento,
                        List<ActividadSocioRequest> actividadesSociosRequest) {

                Movimiento movimiento = movimientoHelper.findByIdOrThrow(idMovimiento);

                List<ActividadSocio> nuevasActividades = new ArrayList<>();

                for (ActividadSocioRequest actividadSocioRequest : actividadesSociosRequest) {

                        ActividadSocio actividadSocio = actividadSocioHelper.construirActividadSocio(
                                        actividadSocioRequest.getIdActividad(),
                                        actividadSocioRequest.getMonto(),
                                        actividadSocioRequest.getCantidad(),
                                        actividadSocioRequest.getFecha(),
                                        actividadSocioRequest.getSocio(),
                                        actividadSocioRequest.getTipoActividad());

                        movimiento.addActividadSocio(actividadSocio);
                        actividadSocioRepository.save(actividadSocio);
                        nuevasActividades.add(actividadSocio);
                }

                movimientoRepository.save(movimiento);

                return nuevasActividades.stream()
                                .map(actividadSocioMapper::toActividadSocioResponseDTO)
                                .toList();
        }

        @Override
        @Transactional()
        public void delete(Long idMovimiento, ArrayList<Long> idActividades) {

                Movimiento movimiento = movimientoHelper.findByIdOrThrow(idMovimiento);

                for (Long idActividad : idActividades) {
                        movimiento.removeActividadSocio(actividadSocioHelper.findByIdOrThrow(idActividad));
                }

                movimientoRepository.save(movimiento);
        }

}
