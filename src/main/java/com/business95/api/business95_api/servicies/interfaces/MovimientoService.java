package com.business95.api.business95_api.servicies.interfaces;

import com.business95.api.business95_api.dtos.requests.MovimientoRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequestDTO;
import com.business95.api.business95_api.dtos.responses.BalanceSocioPorMovimientoResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoUpdateResponseDTO;

public interface MovimientoService {

    MovimientoResponseDTO movimientoPorId(Long idMovimiento);

    BalanceSocioPorMovimientoResponseDTO balanceSociosPorMovimiento(Long idMovimiento);

    MovimientoResponseDTO save(MovimientoRequestDTO movimientoRequestDTO);

    MovimientoUpdateResponseDTO update(Long idMovimiento, MovimientoUpdateRequestDTO MovimientoUpdateRequestDTO);

    void delete(Long idMovimiento);

}
