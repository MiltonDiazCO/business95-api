package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dtos.responses.BalanceInversionRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioRes;
import com.business95.api.business95_api.dtos.responses.SocioRes;

public interface SocioService {

    SocioRes socioFindById(Long idSocio);

    BalanceSocioRes balanceSocio(Long idSocio);

    List<BalanceInversionRes> balanceInversionesPorSocio(Long idSocio);

}
