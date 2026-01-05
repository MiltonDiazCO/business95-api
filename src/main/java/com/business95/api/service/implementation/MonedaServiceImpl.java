package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.entity.Moneda;
import com.business95.api.repository.MonedaRepository;
import com.business95.api.service.interfaces.MonedaService;

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
