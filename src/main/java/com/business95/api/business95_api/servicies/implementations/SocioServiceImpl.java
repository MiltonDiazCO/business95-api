package com.business95.api.business95_api.servicies.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.SocioResponse;
import com.business95.api.business95_api.entities.Socio;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.mappers.SocioMapper;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;

    public SocioServiceImpl(SocioRepository socioRepository, SocioMapper socioMapper) {
        this.socioRepository = socioRepository;
        this.socioMapper = socioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SocioResponse socioFindById(Long idSocio) {

        Socio socio = socioRepository.findById(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));

        return socioMapper.socioToSocioResponseDTO(socio);
    }

}
