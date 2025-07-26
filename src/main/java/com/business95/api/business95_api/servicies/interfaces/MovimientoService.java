package com.business95.api.business95_api.servicies.interfaces;

import com.business95.api.business95_api.dtos.requests.MovimientoRequestDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponseDTO;

public interface MovimientoService {

    MovimientoResponseDTO findMovimientoDTOById(Long idMovimiento);

    MovimientoRequestDTO save(MovimientoRequestDTO movimientoRequestDTO);

    Long delete(Long idMovimiento);

}
