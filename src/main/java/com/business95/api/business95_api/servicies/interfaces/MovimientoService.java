package com.business95.api.business95_api.servicies.interfaces;

import com.business95.api.business95_api.dto.request.MovimientoRequestDTO;
import com.business95.api.business95_api.dto.response.MovimientoResponseDTO;

public interface MovimientoService {

    MovimientoResponseDTO findMovimientoDTOById(Long idMovimiento);

    MovimientoRequestDTO save(MovimientoRequestDTO movimientoRequestDTO);

}
