package com.business95.api.servicies.interfaces;

import java.util.List;

import com.business95.api.dtos.responses.BalanceInversionResponse;
import com.business95.api.dtos.responses.BalanceSocioResponse;
import com.business95.api.dtos.responses.SocioResponse;

public interface SocioService {

    SocioResponse socioFindById(Long idSocio);

    BalanceSocioResponse balanceSocio(Long idSocio);

    List<BalanceInversionResponse> balanceInversionPorSocio(Long idSocio);

}
