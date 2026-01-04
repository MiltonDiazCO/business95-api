package com.business95.api.servicies.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.dtos.requests.ActividadSocioRequest;
import com.business95.api.dtos.responses.ActividadSocioResponse;

public interface ActividadService {

        List<ActividadSocioResponse> save(
                        Long idMovimiento,
                        List<ActividadSocioRequest> actividadesSociosRequest);

        void delete(Long idMovimiento, ArrayList<Long> idActividades);

}
