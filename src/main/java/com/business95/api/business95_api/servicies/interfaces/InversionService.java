package com.business95.api.business95_api.servicies.interfaces;

import com.business95.api.business95_api.dtos.responses.InversionResponse;
import com.business95.api.business95_api.entities.Inversion;

public interface InversionService {

    InversionResponse inversionPorId(Long idInversion);

    Inversion save(Inversion inversion);

    Inversion update(Long idInversion, Inversion inversion);

    void delete(Long idInversion);

}
