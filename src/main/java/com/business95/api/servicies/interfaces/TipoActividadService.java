package com.business95.api.servicies.interfaces;

import java.util.List;

import com.business95.api.entities.TipoActividad;

public interface TipoActividadService {

    List<TipoActividad> findAll();

    TipoActividad findByIdOrThrow(Long idTipoActividad);

}
