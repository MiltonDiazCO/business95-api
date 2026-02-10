package com.business95.api.service.interfaces;

import java.util.List;
import java.util.Set;

import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.InversionConSociosResponse;

public interface InversionSocioService {

    InversionConSociosResponse agregarSociosAInversion(
            Long idInversion,
            Set<SocioRolInversionRequest> socios);

    InversionConSociosResponse modificarRolesDeSociosEnInversion(
        Long idinversion,
        Set<SocioRolInversionRequest> socios
    );

    void eliminarSociosDeInversion(Long idInversion, List<Long> socios);

}
