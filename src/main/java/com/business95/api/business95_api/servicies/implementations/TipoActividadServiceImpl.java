package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.entities.TipoActividad;
import com.business95.api.business95_api.repositories.TipoActividadRepository;
import com.business95.api.business95_api.servicies.interfaces.TipoActividadService;

@Service
public class TipoActividadServiceImpl implements TipoActividadService {

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoActividad> findAll() {
        return (List<TipoActividad>) tipoActividadRepository.findAll();
    }

}
