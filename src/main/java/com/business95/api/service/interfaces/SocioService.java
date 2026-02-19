package com.business95.api.service.interfaces;

import java.util.List;

import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.ResumenMovimientoPorSocioResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.ActividadRecienteResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;

public interface SocioService {

    SocioResponse detalleSocio();

    BalanceSocioResponse balanceSocio();

    List<InversionConBalancesSociosResponse> balanceInversionesPorSocio();

    List<ResumenMovimientoPorSocioResponse> resumenMovimientosPorSocio();

    List<ActividadRecienteResponse> actividadesRecientes();

    SocioNombresResponse nombresSocio(Long idSocio);

}
