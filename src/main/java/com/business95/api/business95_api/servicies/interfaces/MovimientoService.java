package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.business95.api.business95_api.dtos.requests.MovimientoRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.business95_api.dtos.responses.MovimientoConBalancesResponse;
import com.business95.api.business95_api.dtos.responses.BalanceMovimientoResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoResponse;

public interface MovimientoService {

    MovimientoResponse movimientoPorId(Long idMovimiento);

    MovimientoConBalancesResponse balanceSociosPorMovimiento(Long idMovimiento);

    List<BalanceMovimientoResponse> balanceMovimientosPorInversion(Long idInversion);

    MovimientoResponse save(MovimientoRequest movimientoRequest);

    DetalleMovimiento update(Long idMovimiento, MovimientoUpdateRequest MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
