package com.business95.api.service.interfaces;

import java.util.List;

import com.business95.api.dto.response.BalanceInversionResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;

public interface SocioService {

    SocioResponse socioFindById(Long idSocio);

    BalanceSocioResponse balanceSocio(Long idSocio);

    List<BalanceInversionResponse> balanceInversionPorSocio(Long idSocio);

}
