package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dto.MovimientoConsultaDTO;
import com.business95.api.business95_api.dto.MovimientoRegistroDTO;
import com.business95.api.business95_api.entities.Movimiento;

public interface MovimientoService {

    List<Movimiento> findAll();

    List<MovimientoConsultaDTO> findMovimientoDTOById(Long idMovimiento);

    MovimientoRegistroDTO save(MovimientoRegistroDTO movimientoRegistroDTO);

}
