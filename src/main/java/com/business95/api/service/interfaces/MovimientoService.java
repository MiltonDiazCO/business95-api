package com.business95.api.service.interfaces;

import com.business95.api.dto.request.MovimientoRequest;
import com.business95.api.dto.request.ActualizarMovimientoRequest;
import com.business95.api.dto.response.MovimientoConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoResponse;

public interface MovimientoService {

    MovimientoResponse movimientoPorId(Long idMovimiento);

    MovimientoConBalancesSociosResponse balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoResponse guardar(MovimientoRequest movimientoRequest);

    MovimientoResponse actualizar(Long idMovimiento, ActualizarMovimientoRequest actualizarMovimientoRequest);

    void eliminar(Long idMovimiento);

}
