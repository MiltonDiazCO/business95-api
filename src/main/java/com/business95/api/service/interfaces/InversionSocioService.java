package com.business95.api.service.interfaces;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.PaginaResponse;
import com.business95.api.dto.response.SocioPorInversionResponse;

public interface InversionSocioService {

    PaginaResponse<SocioPorInversionResponse> sociosPorInversion(Long idInversion, Pageable pageable);

    String obtenerRolSocioPorInversion(Long idInversion);

    InversionConSociosResponse agregarSociosAInversion(
            Long idInversion,
            Set<SocioRolInversionRequest> socios);

    InversionConSociosResponse modificarRolesDeSociosEnInversion(
            Long idinversion,
            Set<SocioRolInversionRequest> socios);

    void eliminarSociosDeInversion(Long idInversion, List<Long> socios);

}
