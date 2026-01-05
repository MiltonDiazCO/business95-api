package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.TipoActividad;
import com.business95.api.exception.TipoActividadNoEncontradoException;
import com.business95.api.repository.TipoActividadRepository;

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
