package com.business95.api.security.authorization;

import org.springframework.stereotype.Component;

import com.business95.api.exception.InversionSocioNoEncontradoException;
import com.business95.api.repository.InversionSocioRepository;
import com.business95.api.repository.PermisoRepository;
import com.business95.api.security.context.SocioActual;

@Component("inversionSecurity")
public class InversionSecurity {

    private InversionSocioRepository inversionSocioRepository;
    private PermisoRepository permisoRepository;
    private SocioActual socioActual;

    public InversionSecurity(
            InversionSocioRepository inversionSocioRepository,
            PermisoRepository permisoRepository,
            SocioActual socioActual) {
        this.inversionSocioRepository = inversionSocioRepository;
        this.permisoRepository = permisoRepository;
        this.socioActual = socioActual;
    }

    public boolean tienePermiso(String permiso, Long idInversion) {
        String rol = inversionSocioRepository
                .buscarPorInversionYSocio(idInversion, socioActual.getIdSocioActual())
                .orElseThrow(() -> new InversionSocioNoEncontradoException())
                .getRol().getRol();

        return permisoRepository.buscarPorRolYPermiso(rol, permiso).isPresent();
    }

}
