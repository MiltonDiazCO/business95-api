package com.business95.api.service.implementation;

import org.springframework.stereotype.Service;

import com.business95.api.repository.RolRepository;
import com.business95.api.service.interfaces.RolService;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public boolean esRolSistema(String rol) {
        return rolRepository.findByRol(rol).get().getModulo().toString().equals("SISTEMA");
    }

}
