package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dto.projection.MovimientoConsultaDTO;
import com.business95.api.business95_api.dto.request.MovimientoRequestDTO;

public interface MovimientoService {

    List<MovimientoConsultaDTO> findMovimientoDTOById(Long idMovimiento);

    MovimientoRequestDTO save(MovimientoRequestDTO movimientoRequestDTO);

}
