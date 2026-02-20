package com.business95.api.service.interfaces;

import org.springframework.data.domain.Page;

import com.business95.api.dto.request.ActualizarInversionRequest;
import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;

public interface InversionService {

    InversionResponse inversionPorId(Long idInversion);

    InversionConSociosResponse sociosPorInversion(Long idInversion);

    InversionConBalancesSociosResponse balanceSociosPorInversion(Long idInversion);

    Page<ResumenMovimientoResponse> resumenMovimientosPorInversion(Long idInversion, int pagina, int limite);

    InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest);

    InversionResponse actualizarDetalleInversion(
            Long idInversion,
            ActualizarInversionRequest actualizarInversionRequest);

    void eliminarInversion(Long idInversion);

}
