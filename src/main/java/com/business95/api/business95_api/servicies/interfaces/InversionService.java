package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dtos.responses.BalanceInversionRes;
import com.business95.api.business95_api.dtos.responses.BalanceMovsPorInvRes;
import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.entities.Inversion;

public interface InversionService {

    InversionRes inversionPorId(Long idInversion);

    BalanceInversionRes balanceInversion(Long idInversion);

    List<BalanceMovsPorInvRes> balanceMovimientosPorInversion(Long idInversion);

    Inversion save(Inversion inversion);

    Inversion update(Long idInversion, Inversion inversion);

    void delete(Long idInversion);

}
