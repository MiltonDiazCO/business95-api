package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dtos.requests.MovimientoRequest;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequest;
import com.business95.api.business95_api.dtos.responses.MovimientoConBalancesSociosResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoPorInversionResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoUpdateResponse;

public interface MovimientoService {

    MovimientoResponse movimientoPorId(Long idMovimiento);

    MovimientoConBalancesSociosResponse balanceSociosPorMovimiento(Long idMovimiento);

    List<MovimientoPorInversionResponseDTO> findMovimientosPorInversion(Long idInversion);

    MovimientoResponse save(MovimientoRequest movimientoRequest);

    MovimientoUpdateResponse update(Long idMovimiento, MovimientoUpdateRequest MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
