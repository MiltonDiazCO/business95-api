package com.business95.api.servicies.interfaces;

import java.util.List;

import com.business95.api.dtos.requests.InversionRequest;
import com.business95.api.dtos.responses.BalanceInversionResponse;
import com.business95.api.dtos.responses.BalanceMovimientoResponse;
import com.business95.api.dtos.responses.InversionResponse;
import com.business95.api.dtos.responses.InversionConSociosResponse;
import com.business95.api.entities.Inversion;

public interface InversionService {

    InversionResponse inversionPorId(Long idInversion);

    InversionConSociosResponse sociosPorInversion(Long idInversion);

    BalanceInversionResponse balanceInversion(Long idInversion);

    List<BalanceMovimientoResponse> balanceMovimientosPorInversion(Long idInversion);

    InversionConSociosResponse guardarInversionConSocios(InversionRequest inversionRequest);

    InversionResponse update(Long idInversion, Inversion inversion);

    InversionConSociosResponse agregarSociosAInversion(Long idInversion, List<Long> socios);

    void delete(Long idInversion);

    void eliminarSociosDeInversion(Long idInversion, List<Long> socios);

}
