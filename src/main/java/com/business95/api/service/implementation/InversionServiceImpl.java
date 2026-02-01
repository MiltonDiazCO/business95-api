package com.business95.api.service.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.request.ActualizarInversionRequest;
import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.BalanceSocioPorInversionResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.entity.Inversion;
import com.business95.api.entity.Rol;
import com.business95.api.entity.Socio;
import com.business95.api.exception.InversionConMovimientosException;
import com.business95.api.exception.InversionNoEncontradaException;
import com.business95.api.exception.SociosRequeridosException;
import com.business95.api.helper.InversionHelper;
import com.business95.api.helper.InversionSocioHelper;
import com.business95.api.helper.SocioHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.mapper.SocioMapper;
import com.business95.api.projection.BalanceInversionProjection;
import com.business95.api.repository.InversionRepository;
import com.business95.api.repository.InversionSocioRepository;
import com.business95.api.repository.MovimientoRepository;
import com.business95.api.repository.RolRepository;
import com.business95.api.service.interfaces.InversionService;

@Service
public class InversionServiceImpl implements InversionService {

    private final InversionRepository inversionRepository;
    private final MovimientoRepository movimientoRepository;
    private final RolRepository rolRepository;
    private final SocioHelper socioHelper;
    private final InversionHelper inversionHelper;
    private final InversionSocioHelper inversionSocioHelper;
    private final InversionMapper inversionMapper;
    private final SocioMapper socioMapper;

    public InversionServiceImpl(InversionRepository inversionRepository,
            InversionSocioRepository inversionSocioRepository,
            MovimientoRepository movimientoRepository,
            RolRepository rolRepository,
            SocioHelper socioHelper,
            InversionHelper inversionHelper,
            InversionSocioHelper inversionSocioHelper,
            InversionMapper inversionMapper,
            SocioMapper socioMapper) {
        this.inversionRepository = inversionRepository;
        this.movimientoRepository = movimientoRepository;
        this.rolRepository = rolRepository;
        this.socioHelper = socioHelper;
        this.inversionHelper = inversionHelper;
        this.inversionSocioHelper = inversionSocioHelper;
        this.inversionMapper = inversionMapper;
        this.socioMapper = socioMapper;
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
    public InversionConSociosResponse guardarInversionConSocios(
            InversionRequest inversionRequest) {

        Inversion inversion = new Inversion(inversionRequest.getInversion());

        guardarSocios(inversion, inversionRequest.getSocios());

        return inversionMapper.toInversionConSociosResponse(inversionRepository.save(inversion));
    }

    @Override
    @Transactional()
    public InversionConSociosResponse agregarSociosAInversion(
            Long idInversion,
            Set<SocioRolInversionRequest> socios) {

        Inversion inversion = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        if (socios.size() <= 0 || socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        guardarSocios(inversion, socios);

        return inversionMapper.toInversionConSociosResponse(inversionRepository.save(inversion));
    }

    @Override
    @Transactional()
    public void eliminarSociosDeInversion(Long idInversion, List<Long> socios) {

        Inversion inversion = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        if (socios.size() <= 0 || socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (Long idSocio : socios) {
            inversion.removeSocio(inversionSocioHelper.buscarPorIdOLanzarExcepcion(idInversion, idSocio));
        }
    }

    @Override
    @Transactional()
    public InversionResponse actualizarDetalleInversion(
            Long idInversion,
            ActualizarInversionRequest actualizarInversionRequest) {

        Inversion inversionUpdate = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

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

    private void guardarSocios(Inversion inversion, Set<SocioRolInversionRequest> socios) {
        for (SocioRolInversionRequest socioRol : socios) {

            Socio socio = socioHelper.buscarPorIdOLanzarExcepcion(socioRol.getIdSocio());
            Rol rol = rolRepository.findByRol(socioRol.getRol()).get();

            inversion.addSocio(inversionSocioHelper.construirInversionSocio(socio, rol));

        }
    }

}
