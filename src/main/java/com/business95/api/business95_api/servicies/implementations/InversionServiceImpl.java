package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.requests.InversionRequest;
import com.business95.api.business95_api.dtos.responses.BalanceInversionResponse;
import com.business95.api.business95_api.dtos.responses.BalanceMovsPorInvRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioPorInvRes;
import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.dtos.responses.InversionSociosRes;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.SociosRequeridosException;
import com.business95.api.business95_api.exceptions.handlers.InversionConMovimientosException;
import com.business95.api.business95_api.helpers.InversionHelper;
import com.business95.api.business95_api.helpers.SocioHelper;
import com.business95.api.business95_api.mappers.InversionMapper;
import com.business95.api.business95_api.projections.BalanceInversionProjection;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.servicies.interfaces.InversionService;

@Service
public class InversionServiceImpl implements InversionService {

    private final InversionRepository inversionRepository;
    private final InversionHelper inversionHelper;
    private final InversionMapper inversionMapper;
    private final SocioHelper socioHelper;

    public InversionServiceImpl(
            InversionRepository inversionRepository,
            InversionHelper inversionHelper,
            InversionMapper inversionMapper,
            SocioHelper socioHelper) {
        this.inversionRepository = inversionRepository;
        this.inversionHelper = inversionHelper;
        this.inversionMapper = inversionMapper;
        this.socioHelper = socioHelper;
    }

    @Override
    @Transactional(readOnly = true)
    public InversionRes inversionPorId(Long idInversion) {
        return inversionMapper.toInversionResponse(inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    @Transactional(readOnly = true)
    public InversionSociosRes sociosPorInversion(Long idInversion) {
        return inversionMapper.toInversionSociosRes(inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    public BalanceInversionResponse balanceInversion(Long idInversion) {

        BalanceInversionProjection inversionsocioProjection;

        if (inversionRepository.findById(idInversion).isPresent()) {
            inversionsocioProjection = inversionRepository
                    .balanceInversion(null, idInversion)
                    .get(0);
        } else {
            throw new InversionNoEncontradaException(idInversion);
        }

        BalanceInversionResponse inversionResponse = inversionMapper
                .toBalanceInversionResponse(inversionsocioProjection);

        List<BalanceSocioPorInvRes> balances = inversionRepository.balanceSocioPorInversion(idInversion)
                .stream()
                .map(inversionMapper::toBalanceSocioPorInvResponse)
                .toList();

        inversionResponse.setBalances(balances);
        return inversionResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BalanceMovsPorInvRes> balanceMovimientosPorInversion(Long idInversion) {
        return inversionRepository.balanceMovimientosPorInversion(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

    @Override
    @Transactional()
    public InversionSociosRes guardarInversionConSocios(InversionRequest inversionRequest) {

        Inversion inversion = new Inversion(null, inversionRequest.getInversion());

        for (Long socio : inversionRequest.getSocios()) {
            inversion.addSocio(socioHelper.findByIdOrThrow(socio));
        }

        return inversionMapper.toInversionSociosRes(inversionRepository.save(inversion));
    }

    @Override
    @Transactional()
    public InversionRes update(Long idInversion, Inversion inversion) {

        Inversion inversionUpdate = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        inversionUpdate.setInversion(inversion.getInversion());

        return inversionMapper.toInversionResponse(inversionRepository.save(inversionUpdate));
    }

    @Override
    @Transactional()
    public InversionSociosRes agregarSociosAInversion(Long idInversion, List<Long> socios) {

        Inversion inversion = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        if (socios.size() <= 0 || socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (Long socio : socios) {
            inversion.addSocio(socioHelper.findByIdOrThrow(socio));
        }

        return inversionMapper.toInversionSociosRes(inversionRepository.save(inversion));
    }

    @Override
    @Transactional()
    public void delete(Long idInversion) {

        Inversion inversion = inversionHelper.findByIdOrThrow(idInversion);

        if (!inversionRepository.balanceMovimientosPorInversion(idInversion).isEmpty()) {
            throw new InversionConMovimientosException(idInversion);
        }

        inversionRepository.delete(inversion);
    }

    @Override
    @Transactional()
    public void eliminarSociosDeInversion(Long idInversion, List<Long> socios) {

        Inversion inversion = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        if (socios.size() <= 0 || socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (Long socio : socios) {
            inversion.removeSocio(socioHelper.findByIdOrThrow(socio));
        }

        inversionRepository.save(inversion);
    }

}
