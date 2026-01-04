package com.business95.api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.entities.TipoPersona;
import com.business95.api.repositories.TipoPersonaRepository;
import com.business95.api.servicies.interfaces.TipoPersonaService;

@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoPersona> findAll() {
        return (List<TipoPersona>) tipoPersonaRepository.findAll();
    }

}
