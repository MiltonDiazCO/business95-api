package com.business95.api.business95_api.servicies.interfaces;

import java.util.List;

import com.business95.api.business95_api.dtos.responses.InversionResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoPorInversionResponseDTO;
import com.business95.api.business95_api.entities.Inversion;

public interface InversionService {

    Inversion findById(Long idInversion);

    InversionResponseDTO inversionFindById(Long idInversion);

    List<MovimientoPorInversionResponseDTO> findMovimientosPorInversion(Long idInversion);

    Inversion save(Inversion inversion);

    Inversion update(Long idInversion, Inversion inversion);

    void delete(Long idInversion);

}
