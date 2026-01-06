package com.business95.api.service.interfaces;

import com.business95.api.dto.request.MovimientoRequest;
import com.business95.api.dto.request.MovimientoUpdateRequest;
import com.business95.api.dto.response.MovimientoConBalancesResponse;
import com.business95.api.dto.response.MovimientoResponse;

public interface MovimientoService {

    MovimientoResponse movimientoPorId(Long idMovimiento);

    MovimientoConBalancesResponse balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoResponse save(MovimientoRequest movimientoRequest);

    MovimientoResponse update(Long idMovimiento, MovimientoUpdateRequest MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
