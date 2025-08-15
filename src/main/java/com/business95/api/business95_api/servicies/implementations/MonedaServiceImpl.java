package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.entities.Moneda;
import com.business95.api.business95_api.repositories.MonedaRepository;
import com.business95.api.business95_api.servicies.interfaces.MonedaService;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Moneda> findAll() {
        return (List<Moneda>) monedaRepository.findAll();
    }

}
