package com.business95.api.service.interfaces;

import java.util.List;

import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;

public interface SocioService {

    SocioResponse detalleSocio();

    BalanceSocioResponse balanceSocio();

    List<InversionConBalancesSociosResponse> balanceInversionesPorSocio();

    SocioNombresResponse nombresSocio(Long idSocio);

}
