package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.repositories.TipoActividadRepository;
import com.business95.api.business95_api.servicies.interfaces.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    public List<ActividadSocioRequestDTO> save(Long idMovimiento,
            List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs) {

        Movimiento movimiento = movimientoRepository.findById(idMovimiento)
                .orElseThrow(() -> new MovimientoNoEncontradoException(idMovimiento));

        for (ActividadSocioRequestDTO actividadSocioRequestDTO : actividadesSocioRequestDTOs) {
            ActividadSocio actividadSocio = new ActividadSocio();
            actividadSocio.setMonto(actividadSocioRequestDTO.getMonto());
            actividadSocio.setCantidad(actividadSocioRequestDTO.getCantidad());
            actividadSocio.setFecha(actividadSocioRequestDTO.getFecha());

            actividadSocio.setSocio(socioRepository.findById(actividadSocioRequestDTO.getSocio())
                    .orElseThrow(() -> new SocioNoEncontradoException(actividadSocioRequestDTO.getSocio())));

            actividadSocio.setTipoActividad(
                    tipoActividadRepository.findById(actividadSocioRequestDTO.getTipoActividad()).orElseThrow(
                            () -> new TipoActividadNoEncontradoException(actividadSocioRequestDTO.getTipoActividad())));

            movimiento.addActividadSocio(actividadSocio);
        }

        movimientoRepository.save(movimiento);

        return actividadesSocioRequestDTOs;
    }

}
