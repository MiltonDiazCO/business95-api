package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.entity.TipoPersona;
import com.business95.api.repository.TipoPersonaRepository;
import com.business95.api.service.interfaces.TipoPersonaService;

@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("@catalogoSecurity.tienePermiso('CONSULTAR_TIPO_PERSONAS')")
    public List<TipoPersona> obtenerTodos() {
        return (List<TipoPersona>) tipoPersonaRepository.findAll();
    }

}
