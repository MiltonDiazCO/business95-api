package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.TipoActividad;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
import com.business95.api.business95_api.repositories.TipoActividadRepository;

@Component
public class TipoActividadHelper {

    private TipoActividadRepository tipoActividadRepository;

    public TipoActividadHelper(TipoActividadRepository tipoActividadRepository) {
        this.tipoActividadRepository = tipoActividadRepository;
    }

    public TipoActividad findByIdOrThrow(Long idTipoActividad) {
        return tipoActividadRepository.findById(idTipoActividad)
                .orElseThrow(() -> new TipoActividadNoEncontradoException(idTipoActividad));
    }

}
