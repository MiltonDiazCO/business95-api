package com.business95.api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.entities.TipoActividad;
import com.business95.api.exceptions.TipoActividadNoEncontradoException;
import com.business95.api.repositories.TipoActividadRepository;

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
