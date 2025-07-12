package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dto.MovimientoDTO;
import com.business95.api.business95_api.entities.Movimiento;

public interface MovimientoService {

    List<Movimiento> findAll();

    MovimientoDTO save(MovimientoDTO movimiento);

}
