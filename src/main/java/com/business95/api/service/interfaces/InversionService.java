package com.business95.api.service.interfaces;

import org.springframework.data.domain.Pageable;

import com.business95.api.dto.request.ActualizarInversionRequest;
import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.response.DetalleMovimientoResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.dto.response.PaginaResponse;

public interface InversionService {

    InversionResponse inversionPorId(Long idInversion);

    InversionConSociosResponse sociosPorInversion(Long idInversion);

    InversionConBalancesSociosResponse balanceSociosPorInversion(Long idInversion);

    PaginaResponse<DetalleMovimientoResponse> movimientosPorInversion(Long idInversion, Pageable pageable);

    InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest);

    InversionResponse actualizarDetalleInversion(
            Long idInversion,
            ActualizarInversionRequest actualizarInversionRequest);

    void eliminarInversion(Long idInversion);

}
