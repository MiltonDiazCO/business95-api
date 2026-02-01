package com.business95.api.service.interfaces;

import java.util.List;
import java.util.Set;

import com.business95.api.dto.request.ActualizarInversionRequest;
import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;

public interface InversionService {

    InversionResponse inversionPorId(Long idInversion);

    InversionConSociosResponse sociosPorInversion(Long idInversion);

    InversionConBalancesSociosResponse balanceSociosPorInversion(Long idInversion);

    List<ResumenMovimientoResponse> resumenMovimientosPorInversion(Long idInversion);

    InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest);

    InversionConSociosResponse agregarSociosAInversion(Long idInversion, Set<SocioRolInversionRequest> socios);

    InversionResponse actualizarDetalleInversion(
            Long idInversion,
            ActualizarInversionRequest actualizarInversionRequest);

    void eliminarInversion(Long idInversion);

    void eliminarSociosDeInversion(Long idInversion, List<Long> socios);

}
