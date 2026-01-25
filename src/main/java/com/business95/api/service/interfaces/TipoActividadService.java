package com.business95.api.service.interfaces;

import java.util.List;

import com.business95.api.entity.TipoActividad;

public interface TipoActividadService {

    List<TipoActividad> obtenerTodos();

    TipoActividad obtenerPorId(Long idTipoActividad);

}
