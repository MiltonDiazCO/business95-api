package com.business95.api.business95_api.servicies.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.SocioResponse;
import com.business95.api.business95_api.helpers.SocioHelper;
import com.business95.api.business95_api.mappers.SocioMapper;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    private final SocioHelper socioHelper;
    private final SocioMapper socioMapper;

    public SocioServiceImpl(SocioHelper socioHelper, SocioMapper socioMapper) {
        this.socioHelper = socioHelper;
        this.socioMapper = socioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SocioResponse socioFindById(Long idSocio) {
        return socioMapper.toSocioResponseDTO(socioHelper.findByIdOrThrow(idSocio));
    }

}
