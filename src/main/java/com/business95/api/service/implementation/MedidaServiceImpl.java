package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.entity.Medida;
import com.business95.api.repository.MedidaRepository;
import com.business95.api.service.interfaces.MedidaService;

@Service
public class MedidaServiceImpl implements MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("@catalogoSecurity.tienePermiso('CONSULTAR_MEDIDAS')")
    public List<Medida> obtenerTodos() {
        return (List<Medida>) medidaRepository.findAll();
    }

}
