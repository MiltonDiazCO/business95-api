package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.requests.InversionRequest;
import com.business95.api.business95_api.dtos.responses.BalanceInversionResponse;
import com.business95.api.business95_api.dtos.responses.BalanceMovimientoResponse;
import com.business95.api.business95_api.dtos.responses.BalanceSocioResponse;
import com.business95.api.business95_api.dtos.responses.InversionResponse;
import com.business95.api.business95_api.dtos.responses.InversionConSociosResponse;
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
    public InversionResponse inversionPorId(Long idInversion) {
        return inversionMapper.toInversionResponse(inversionHelper.findByIdOrThrow(idInversion));
    }

    @Override
    @Transactional(readOnly = true)
    public InversionConSociosResponse sociosPorInversion(Long idInversion) {
        return inversionMapper.toInversionConSociosResponse(inversionHelper.findByIdOrThrow(idInversion));
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

        List<BalanceSocioResponse> balances = inversionRepository.balanceSocioPorInversion(idInversion)
                .stream()
                .map(inversionMapper::toBalanceSocioPorInvResponse)
                .toList();

        inversionResponse.setBalancesPorSocio(balances);
        return inversionResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BalanceMovimientoResponse> balanceMovimientosPorInversion(Long idInversion) {
        return inversionRepository.balanceMovimientosPorInversion(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

    @Override
    @Transactional()
    public InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest) {

        Inversion inversion = new Inversion(null, inversionRequest.getInversion());

        for (Long socio : inversionRequest.getSocios()) {
            inversion.addSocio(socioHelper.findByIdOrThrow(socio));
        }

        return inversionMapper.toInversionConSociosResponse(inversionRepository.save(inversion));
    }

    @Override
    @Transactional()
    public InversionResponse update(Long idInversion, Inversion inversion) {

        Inversion inversionUpdate = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        inversionUpdate.setInversion(inversion.getInversion());

        return inversionMapper.toInversionResponse(inversionRepository.save(inversionUpdate));
    }

    @Override
    @Transactional()
    public InversionConSociosResponse agregarSociosAInversion(Long idInversion, List<Long> socios) {

        Inversion inversion = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        if (socios.size() <= 0 || socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (Long socio : socios) {
            inversion.addSocio(socioHelper.findByIdOrThrow(socio));
        }

        return inversionMapper.toInversionConSociosResponse(inversionRepository.save(inversion));
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
