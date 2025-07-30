package com.business95.api.business95_api.servicies.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;

public interface ActividadService {

    List<ActividadSocioRequestDTO> save(Long idMovimiento, List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs);

    void delete(Long idMovimiento, ArrayList<Long> idActividades);

}
