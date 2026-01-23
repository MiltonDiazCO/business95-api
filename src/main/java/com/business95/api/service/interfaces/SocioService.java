package com.business95.api.service.interfaces;

import java.util.List;

import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;

public interface SocioService {

    SocioResponse socioFindById(Long idSocio);

    SocioNombresResponse nombresSocioPorId(Long idSocio);

    BalanceSocioResponse balanceSocio(Long idSocio);

    List<InversionConBalancesSociosResponse> balanceInversionPorSocio(Long idSocio);

}
