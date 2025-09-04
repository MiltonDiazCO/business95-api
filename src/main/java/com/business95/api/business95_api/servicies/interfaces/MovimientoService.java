package com.business95.api.business95_api.servicies.interfaces;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.business95.api.business95_api.dtos.requests.MovimientoRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.business95_api.dtos.responses.MovConBalancesSociosRes;
import com.business95.api.business95_api.dtos.responses.MovimientoRes;

public interface MovimientoService {

    MovimientoRes movimientoPorId(Long idMovimiento);

    MovConBalancesSociosRes balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoRes save(MovimientoRequest movimientoRequest);

    DetalleMovimiento update(Long idMovimiento, MovimientoUpdateRequest MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
