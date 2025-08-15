package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.entities.Medida;
import com.business95.api.business95_api.repositories.MedidaRepository;
import com.business95.api.business95_api.servicies.interfaces.MedidaService;

@Service
public class MedidaServiceImpl implements MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Medida> findAll() {
        return (List<Medida>) medidaRepository.findAll();
    }

}
