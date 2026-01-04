package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dtos.requests.InversionRequest;
import com.business95.api.business95_api.dtos.responses.BalanceInversionResponse;
import com.business95.api.business95_api.dtos.responses.BalanceMovimientoResponse;
import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.dtos.responses.InversionSociosRes;
import com.business95.api.business95_api.entities.Inversion;

public interface InversionService {

    InversionRes inversionPorId(Long idInversion);

    InversionSociosRes sociosPorInversion(Long idInversion);

    BalanceInversionResponse balanceInversion(Long idInversion);

    List<BalanceMovimientoResponse> balanceMovimientosPorInversion(Long idInversion);

    InversionSociosRes guardarInversionConSocios(InversionRequest inversionRequest);

    InversionRes update(Long idInversion, Inversion inversion);

    InversionSociosRes agregarSociosAInversion(Long idInversion, List<Long> socios);

    void delete(Long idInversion);

    void eliminarSociosDeInversion(Long idInversion, List<Long> socios);

}
