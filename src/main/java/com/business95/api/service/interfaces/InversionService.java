package com.business95.api.service.interfaces;

import java.util.List;

import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.entity.Inversion;

public interface InversionService {

    InversionResponse inversionPorId(Long idInversion);

    InversionConSociosResponse sociosPorInversion(Long idInversion);

    InversionConBalancesSociosResponse balanceSociosPorInversion(Long idInversion);

    List<ResumenMovimientoResponse> resumenMovimientosPorInversion(Long idInversion);

    InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest);

    InversionConSociosResponse agregarSociosAInversion(Long idInversion, List<Long> socios);

    InversionResponse actualizarDetalleInversion(Long idInversion, Inversion inversion);

    void eliminarInversion(Long idInversion);

    void eliminarSociosDeInversion(Long idInversion, List<Long> socios);

}
