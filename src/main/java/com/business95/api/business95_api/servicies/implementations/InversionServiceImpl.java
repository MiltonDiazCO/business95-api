package com.business95.api.business95_api.servicies.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.InversionResponse;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.helpers.InversionHelper;
import com.business95.api.business95_api.mappers.InversionMapper;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.servicies.interfaces.InversionService;

@Service
public class InversionServiceImpl implements InversionService {

    private final InversionRepository inversionRepository;
    private final InversionHelper inversionHelper;
    private final InversionMapper inversionMapper;

    public InversionServiceImpl(
            InversionRepository inversionRepository,
            InversionHelper inversionHelper,
            InversionMapper inversionMapper) {
        this.inversionRepository = inversionRepository;
        this.inversionHelper = inversionHelper;
        this.inversionMapper = inversionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public InversionResponse inversionPorId(Long idInversion) {
        return inversionMapper.toInversionResponse(
                inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    @Transactional()
    public Inversion save(Inversion inversion) {
        return inversionRepository.save(inversion);
    }

    @Override
    @Transactional()
    public Inversion update(Long idInversion, Inversion inversion) {
        return inversionRepository.save(
                inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    @Transactional()
    public void delete(Long idInversion) {
        inversionHelper.findByIdOrThrow(idInversion);
        inversionRepository.deleteById(idInversion);
    }

}
