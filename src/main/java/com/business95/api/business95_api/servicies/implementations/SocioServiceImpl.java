package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.BalanceAnualSocioRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioRes;
import com.business95.api.business95_api.dtos.responses.SocioRes;
import com.business95.api.business95_api.helpers.SocioHelper;
import com.business95.api.business95_api.mappers.SocioMapper;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;
    private final SocioHelper socioHelper;
    private final SocioMapper socioMapper;

    public SocioServiceImpl(SocioRepository socioRepository, SocioHelper socioHelper, SocioMapper socioMapper) {
        this.socioRepository = socioRepository;
        this.socioHelper = socioHelper;
        this.socioMapper = socioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SocioRes socioFindById(Long idSocio) {
        return socioMapper.toSocioResponseDTO(socioHelper.findByIdOrThrow(idSocio));
    }

    @Override
    public BalanceSocioRes balanceSocio(Long idSocio) {

        socioHelper.findByIdOrThrow(idSocio);
        BalanceSocioRes socioResponse = socioMapper.toBalanceSocioResponse(socioRepository.balanceSocio(idSocio));

        List<BalanceAnualSocioRes> balances = socioRepository.balanceAnualSocio(idSocio)
                .stream()
                .map(socioMapper::toBalanceAnualSocioResponse)
                .toList();

        socioResponse.setBalances(balances);

        return socioResponse;
    }

}
