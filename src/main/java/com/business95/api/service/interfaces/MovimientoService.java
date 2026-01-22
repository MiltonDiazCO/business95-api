package com.business95.api.service.interfaces;

import com.business95.api.dto.request.MovimientoRequest;
import com.business95.api.dto.request.MovimientoUpdateRequest;
import com.business95.api.dto.response.MovimientoConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoResponse;

public interface MovimientoService {

    MovimientoResponse movimientoPorId(Long idMovimiento);

    MovimientoConBalancesSociosResponse balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoResponse save(MovimientoRequest movimientoRequest);

    MovimientoResponse update(Long idMovimiento, MovimientoUpdateRequest MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
