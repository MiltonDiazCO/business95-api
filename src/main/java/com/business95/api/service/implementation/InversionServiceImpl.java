package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.request.ActualizarInversionRequest;
import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.response.BalanceSocioPorInversionResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.entity.Inversion;
import com.business95.api.exception.InversionConMovimientosException;
import com.business95.api.exception.InversionNoEncontradaException;
import com.business95.api.helper.InversionHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.mapper.SocioMapper;
import com.business95.api.projection.BalanceInversionProjection;
import com.business95.api.repository.InversionRepository;
import com.business95.api.repository.MovimientoRepository;
import com.business95.api.service.interfaces.InversionSocioService;
import com.business95.api.service.interfaces.InversionService;

@Service
public class InversionServiceImpl implements InversionService {

    private final InversionRepository inversionRepository;
    private final MovimientoRepository movimientoRepository;
    private final InversionHelper inversionHelper;
    private final InversionMapper inversionMapper;
    private final SocioMapper socioMapper;
    private final InversionSocioService inversionSocioService;

    public InversionServiceImpl(InversionRepository inversionRepository,
            MovimientoRepository movimientoRepository,
            InversionHelper inversionHelper,
            InversionMapper inversionMapper,
            SocioMapper socioMapper,
            InversionSocioService inversionSocioService) {
        this.inversionRepository = inversionRepository;
        this.movimientoRepository = movimientoRepository;
        this.inversionHelper = inversionHelper;
        this.inversionMapper = inversionMapper;
        this.socioMapper = socioMapper;
        this.inversionSocioService = inversionSocioService;
    }

    @Override
    @Transactional(readOnly = true)
    public InversionResponse inversionPorId(Long idInversion) {
        return inversionMapper.toInversionResponse(
                inversionHelper.buscarPorIdOLanzarExcepcion(idInversion));
    }

    @Override
    @Transactional(readOnly = true)
    public InversionConSociosResponse sociosPorInversion(Long idInversion) {
        return inversionMapper.toInversionConSociosResponse(
                inversionHelper.buscarPorIdOLanzarExcepcion(idInversion));
    }

    @Override
    public InversionConBalancesSociosResponse balanceSociosPorInversion(Long idInversion) {

        BalanceInversionProjection inversionProjection;

        if (inversionRepository.findById(idInversion).isPresent()) {
            inversionProjection = inversionRepository
                    .balanceInversionPorIdSocioOIdInversion(null, idInversion)
                    .get(0);
        } else {
            throw new InversionNoEncontradaException(idInversion);
        }

        InversionConBalancesSociosResponse inversionResponse = inversionMapper
                .toBalanceInversionResponse(inversionProjection);

        List<BalanceSocioPorInversionResponse> balances = inversionRepository
                .balanceSociosPorInversion(idInversion)
                .stream()
                .map(socioMapper::toBalanceSocioPorInversionResponse)
                .toList();

        inversionResponse.setBalancesPorSocio(balances);
        return inversionResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResumenMovimientoResponse> resumenMovimientosPorInversion(Long idInversion) {
        return movimientoRepository.resumenMovimientosPorInversion(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

    @Override
    @Transactional()
    public InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest) {

        Inversion inversion = inversionRepository.save(new Inversion(inversionRequest.getInversion()));

        return inversionSocioService.agregarSociosAInversion(
                inversion.getIdInversion(),
                inversionRequest.getSocios());
    }

    @Override
    @Transactional()
    public InversionResponse actualizarDetalleInversion(
            Long idInversion,
            ActualizarInversionRequest actualizarInversionRequest) {

        Inversion inversionUpdate = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        inversionUpdate.setInversion(actualizarInversionRequest.getInversion());

        return inversionMapper.toInversionResponse(inversionRepository.save(inversionUpdate));
    }

    @Override
    @Transactional()
    public void eliminarInversion(Long idInversion) {

        Inversion inversion = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        if (!movimientoRepository.resumenMovimientosPorInversion(idInversion).isEmpty()) {
            throw new InversionConMovimientosException(idInversion);
        }

        inversionRepository.delete(inversion);
    }

}
