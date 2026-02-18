package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.response.BalanceAnualSocioResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.ResumenMovimientoPorSocioResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;
import com.business95.api.exception.SocioNoEncontradoException;
import com.business95.api.helper.SocioHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.mapper.SocioMapper;
import com.business95.api.projection.BalanceSocioProjection;
import com.business95.api.repository.InversionRepository;
import com.business95.api.repository.MovimientoRepository;
import com.business95.api.repository.SocioRepository;
import com.business95.api.security.context.SocioActual;
import com.business95.api.service.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;
    private final InversionRepository inversionRepository;
    private final MovimientoRepository movimientoRepository;
    private final SocioHelper socioHelper;
    private final SocioMapper socioMapper;
    private final SocioActual socioActual;
    private final InversionMapper inversionMapper;

    public SocioServiceImpl(SocioRepository socioRepository,
            InversionRepository inversionRepository,
            MovimientoRepository movimientoRepository,
            SocioHelper socioHelper,
            SocioMapper socioMapper,
            SocioActual socioActual,
            InversionMapper inversionMapper) {
        this.socioRepository = socioRepository;
        this.inversionRepository = inversionRepository;
        this.movimientoRepository = movimientoRepository;
        this.socioHelper = socioHelper;
        this.socioMapper = socioMapper;
        this.socioActual = socioActual;
        this.inversionMapper = inversionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SocioResponse detalleSocio() {
        Long idSocio = socioActual.getIdSocioActual();
        return socioMapper.toSocioResponseDTO(socioHelper.buscarPorIdOLanzarExcepcion(idSocio));
    }

    @Override
    @Transactional(readOnly = true)
    public BalanceSocioResponse balanceSocio() {

        Long idSocio = socioActual.getIdSocioActual();

        BalanceSocioProjection socioProjection = socioRepository
                .balanceSocio(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));

        BalanceSocioResponse socioResponse = socioMapper.toBalanceSocioResponse(socioProjection);

        List<BalanceAnualSocioResponse> balances = socioRepository.balanceAnualSocio(idSocio)
                .stream()
                .map(socioMapper::toBalanceAnualSocioResponse)
                .toList();

        socioResponse.setHistorialAnual(balances);

        return socioResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InversionConBalancesSociosResponse> balanceInversionesPorSocio() {
        Long idSocio = socioActual.getIdSocioActual();

        return inversionRepository
                .balanceInversionPorIdSocioOIdInversion(idSocio, null)
                .stream()
                .map(inversionMapper::toBalanceInversionResponse)
                .toList();
    }

    @Override
    public List<ResumenMovimientoPorSocioResponse> resumenMovimientosPorSocio() {
        Long idSocio = socioActual.getIdSocioActual();
        return movimientoRepository.resumenMovimientosPorSocio(idSocio);
    }

    @Override
    @Transactional(readOnly = true)
    public SocioNombresResponse nombresSocio(Long idSocio) {
        return socioMapper.toSocioNombresResponse(socioHelper.buscarPorIdOLanzarExcepcion(idSocio));
    }

}
