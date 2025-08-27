package com.business95.api.business95_api.helpers;

import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Socio;
import com.business95.api.business95_api.entities.TipoActividad;
import com.business95.api.business95_api.exceptions.ActividadSocioNoEncontradaException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
import com.business95.api.business95_api.repositories.ActividadSocioRepository;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.repositories.TipoActividadRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class ActividadSocioHelper {

    private final ActividadSocioRepository actividadSocioRepository;
    private final SocioRepository socioRepository;
    private final TipoActividadRepository tipoActividadRepository;

    public ActividadSocioHelper(
            ActividadSocioRepository actividadSocioRepository,
            SocioRepository socioRepository,
            TipoActividadRepository tipoActividadRepository) {
        this.actividadSocioRepository = actividadSocioRepository;
        this.socioRepository = socioRepository;
        this.tipoActividadRepository = tipoActividadRepository;
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
            actividadSocio = actividadSocioRepository.findById(idActividad)
                    .orElseThrow(() -> new ActividadSocioNoEncontradaException(idActividad));
        }

        actividadSocio.setMonto(monto);
        actividadSocio.setCantidad(cantidad);
        actividadSocio.setFecha(fecha);

        Socio socio = socioRepository.findById(idSocio).orElseThrow(() -> new SocioNoEncontradoException(idSocio));
        actividadSocio.setSocio(socio);

        TipoActividad tipoActividad = tipoActividadRepository.findById(idTipoActividad)
                .orElseThrow(() -> new TipoActividadNoEncontradoException(idTipoActividad));
        actividadSocio.setTipoActividad(tipoActividad);

        return actividadSocio;
    }
}
