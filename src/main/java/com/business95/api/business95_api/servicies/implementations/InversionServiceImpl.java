package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.BalanceInversionRes;
import com.business95.api.business95_api.dtos.responses.BalanceMovsPorInvRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioPorInvRes;
import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.helpers.InversionHelper;
import com.business95.api.business95_api.mappers.InversionMapper;
import com.business95.api.business95_api.projections.BalanceInversionProjection;
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
    public InversionRes inversionPorId(Long idInversion) {
        return inversionMapper.toInversionResponse(inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    public BalanceInversionRes balanceInversion(Long idInversion) {
        BalanceInversionProjection inversionsocioProjection = inversionRepository.balanceInversion(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        BalanceInversionRes invResponse = inversionMapper.toBalanceInversionResponse(inversionsocioProjection);

        List<BalanceSocioPorInvRes> balances = inversionRepository.balanceSocioPorInversion(idInversion)
                .stream()
                .map(inversionMapper::toBalanceSocioPorInvResponse)
                .toList();

        invResponse.setBalances(balances);
        return invResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BalanceMovsPorInvRes> balanceMovimientosPorInversion(Long idInversion) {
        return inversionRepository.balanceMovimientosPorInversion(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

    @Override
    @Transactional()
    public Inversion save(Inversion inversion) {
        return inversionRepository.save(inversion);
    }

    @Override
    @Transactional()
    public Inversion update(Long idInversion, Inversion inversion) {
        return inversionRepository.save(inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    @Transactional()
    public void delete(Long idInversion) {
        inversionRepository.delete(inversionHelper.findByIdOrThrow(idInversion));
    }

}
