package com.business95.api.servicies.interfaces;

import com.business95.api.dtos.requests.MovimientoRequest;
import com.business95.api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.dtos.responses.MovConBalancesSociosRes;
import com.business95.api.dtos.responses.MovimientoResponse;

public interface MovimientoService {

    MovimientoResponse movimientoPorId(Long idMovimiento);

    MovConBalancesSociosRes balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoResponse save(MovimientoRequest movimientoRequest);

    MovimientoResponse update(Long idMovimiento, MovimientoUpdateRequest MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
