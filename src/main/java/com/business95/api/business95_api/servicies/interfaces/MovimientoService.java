package com.business95.api.business95_api.servicies.interfaces;

import com.business95.api.business95_api.dtos.requests.MovimientoRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequestDTO;
import com.business95.api.business95_api.dtos.responses.BalanceSociosPorMovimientoResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponseDTO;

public interface MovimientoService {

    MovimientoResponseDTO movimientoPorId(Long idMovimiento);

    BalanceSociosPorMovimientoResponseDTO balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoRequestDTO save(MovimientoRequestDTO movimientoRequestDTO);

    MovimientoUpdateRequestDTO update(Long idMovimiento, MovimientoUpdateRequestDTO MovimientoUpdateRequestDTO);

    Long delete(Long idMovimiento);

}
