package com.business95.api.helper;

import com.business95.api.entity.ActividadSocio;
import com.business95.api.exception.ActividadSocioNoEncontradaException;
import com.business95.api.repository.ActividadSocioRepository;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class ActividadSocioHelper {

    private final ActividadSocioRepository actividadSocioRepository;
    private final SocioHelper socioHelper;
    private final TipoActividadHelper tipoActividadHelper;

    public ActividadSocioHelper(
            ActividadSocioRepository actividadSocioRepository,
            SocioHelper socioHelper,
            TipoActividadHelper tipoActividadHelper) {
        this.actividadSocioRepository = actividadSocioRepository;
        this.socioHelper = socioHelper;
        this.tipoActividadHelper = tipoActividadHelper;
    }

    public ActividadSocio buscarPorIdOLanzarExcepcion(Long idActividad) {
        return actividadSocioRepository.findById(idActividad)
                .orElseThrow(() -> new ActividadSocioNoEncontradaException(idActividad));
    }

    public ActividadSocio construirActividadSocio(
            Long idActividad,
            BigDecimal monto,
            BigDecimal cantidad,
            LocalDateTime fecha,
            Long idSocio,
            Long idTipoActividad) {

        ActividadSocio actividadSocio = new ActividadSocio();

        if (idActividad != null) {
            actividadSocio = buscarPorIdOLanzarExcepcion(idActividad);
        }

        actividadSocio.setMonto(monto);
        actividadSocio.setCantidad(cantidad);
        actividadSocio.setFecha(fecha);
        actividadSocio.setSocio(socioHelper.buscarPorIdOLanzarExcepcion(idSocio));
        actividadSocio.setTipoActividad(tipoActividadHelper.buscarPorIdOLanzarExcepcion(idTipoActividad));

        return actividadSocio;
    }
}
