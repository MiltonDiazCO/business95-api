package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.entity.TipoActividad;
import com.business95.api.exception.TipoActividadNoEncontradoException;
import com.business95.api.repository.TipoActividadRepository;
import com.business95.api.service.interfaces.TipoActividadService;

@Service
public class TipoActividadServiceImpl implements TipoActividadService {

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("@catalogoSecurity.tienePermiso('CONSULTAR_TIPO_ACTIVIDADES')")
    public List<TipoActividad> obtenerTodos() {
        return (List<TipoActividad>) tipoActividadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("@catalogoSecurity.tienePermiso('CONSULTAR_TIPO_ACTIVIDAD_POR_ID')")
    public TipoActividad obtenerPorId(Long idTipoActividad) {
        return (TipoActividad) tipoActividadRepository.findById(idTipoActividad)
                .orElseThrow(() -> new TipoActividadNoEncontradoException(idTipoActividad));
    }

}
