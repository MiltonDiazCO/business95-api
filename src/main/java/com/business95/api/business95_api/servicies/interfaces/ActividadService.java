package com.business95.api.business95_api.servicies.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;
import com.business95.api.business95_api.dtos.responses.ActividadSocioResponseDTO;

public interface ActividadService {

        List<ActividadSocioResponseDTO> save(
                        Long idMovimiento,
                        List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs);

        void delete(Long idMovimiento, ArrayList<Long> idActividades);

}
