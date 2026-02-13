package com.business95.api.security.authorization;

import org.springframework.stereotype.Component;

import com.business95.api.repository.InversionSocioRepository;
import com.business95.api.security.context.SocioActual;

@Component("inversionSecurity")
public class InversionSecurity {

    private InversionSocioRepository inversionSocioRepository;
    private SocioActual socioActual;

    public InversionSecurity(
            InversionSocioRepository inversionSocioRepository,
            SocioActual socioActual) {
        this.inversionSocioRepository = inversionSocioRepository;
        this.socioActual = socioActual;
    }

    public boolean esParticipante(Long idInversion) {
        return inversionSocioRepository.buscarPorInversionYSocio(
                idInversion, socioActual.getIdSocioActual()).isPresent();
    }

    public boolean esInversionAdmin(Long idInversion) {
        return inversionSocioRepository
                .buscarPorInversionYSocio(idInversion, socioActual.getIdSocioActual())
                .map((socio) -> socio.getRol().getRol().equals("ROLE_INVERSION_ADMIN"))
                .orElse(false);
    }

}
