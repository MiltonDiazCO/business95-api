package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.response.BalanceAnualSocioResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;
import com.business95.api.exception.SocioNoEncontradoException;
import com.business95.api.helper.SocioHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.mapper.SocioMapper;
import com.business95.api.projection.BalanceSocioProjection;
import com.business95.api.repository.InversionRepository;
import com.business95.api.repository.SocioRepository;
import com.business95.api.service.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;
    private final InversionRepository inversionRepository;
    private final SocioHelper socioHelper;
    private final SocioMapper socioMapper;
    private final InversionMapper inversionMapper;

    public SocioServiceImpl(SocioRepository socioRepository,
            InversionRepository inversionRepository,
            SocioHelper socioHelper,
            SocioMapper socioMapper,
            InversionMapper inversionMapper) {
        this.socioRepository = socioRepository;
        this.inversionRepository = inversionRepository;
        this.socioHelper = socioHelper;
        this.socioMapper = socioMapper;
        this.inversionMapper = inversionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SocioResponse socioPorId(Long idSocio) {
        return socioMapper.toSocioResponseDTO(socioHelper.findByIdOrThrow(idSocio));
    }

    @Override
    @Transactional(readOnly = true)
    public SocioNombresResponse nombresSocio(Long idSocio) {
        return socioMapper.toSocioNombresResponse(socioHelper.findByIdOrThrow(idSocio));
    }

    @Override
    @Transactional(readOnly = true)
    public BalanceSocioResponse balanceSocio(Long idSocio) {

        BalanceSocioProjection socioProjection = socioRepository.balanceSocio(idSocio)
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
    public List<InversionConBalancesSociosResponse> balanceInversionPorSocio(Long idSocio) {
        return inversionRepository
                .balanceInversionPorIdSocioOIdInversion(idSocio, null)
                .stream()
                .map(inversionMapper::toBalanceInversionResponse)
                .toList();
    }

}
