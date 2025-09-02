package com.business95.api.business95_api.helpers;

import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.exceptions.ActividadSocioNoEncontradaException;
import com.business95.api.business95_api.repositories.ActividadSocioRepository;
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

    public ActividadSocio findByIdOrThrow(Long idActividad) {
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
            actividadSocio = findByIdOrThrow(idActividad);
        }

        actividadSocio.setMonto(monto);
        actividadSocio.setCantidad(cantidad);
        actividadSocio.setFecha(fecha);
        actividadSocio.setSocio(socioHelper.findByIdOrThrow(idSocio));
        actividadSocio.setTipoActividad(tipoActividadHelper.findByIdOrThrow(idTipoActividad));

        return actividadSocio;
    }
}
