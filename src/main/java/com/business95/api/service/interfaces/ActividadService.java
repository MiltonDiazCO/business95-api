package com.business95.api.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.dto.request.ActividadSocioRequest;
import com.business95.api.dto.response.ActividadSocioResponse;

public interface ActividadService {

        List<ActividadSocioResponse> guardar(
                        Long idMovimiento,
                        List<ActividadSocioRequest> actividadesSociosRequest);

        void eliminar(Long idMovimiento, ArrayList<Long> idActividades);

}
