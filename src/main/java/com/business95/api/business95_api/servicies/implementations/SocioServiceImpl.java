package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.BalanceAnualSocioRes;
import com.business95.api.business95_api.dtos.responses.BalanceInversionRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioRes;
import com.business95.api.business95_api.dtos.responses.SocioRes;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.helpers.SocioHelper;
import com.business95.api.business95_api.mappers.InversionMapper;
import com.business95.api.business95_api.mappers.SocioMapper;
import com.business95.api.business95_api.projections.BalanceSocioProjection;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

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
    public SocioRes socioFindById(Long idSocio) {
        return socioMapper.toSocioResponseDTO(socioHelper.findByIdOrThrow(idSocio));
    }

    @Override
    public BalanceSocioRes balanceSocio(Long idSocio) {

        BalanceSocioProjection socioProjection = socioRepository.balanceSocio(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));

        BalanceSocioRes socioResponse = socioMapper.toBalanceSocioResponse(socioProjection);

        List<BalanceAnualSocioRes> balances = socioRepository.balanceAnualSocio(idSocio)
                .stream()
                .map(socioMapper::toBalanceAnualSocioResponse)
                .toList();

        socioResponse.setBalances(balances);

        return socioResponse;
    }

    public List<BalanceInversionRes> balanceInversionesPorSocio(Long idSocio) {
        return inversionRepository.balanceInversion(idSocio, null)
                .stream()
                .map(inversionMapper::toBalanceInversionResponse)
                .toList();
    }

}
