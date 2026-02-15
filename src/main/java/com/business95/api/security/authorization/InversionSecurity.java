package com.business95.api.security.authorization;

import org.springframework.stereotype.Component;

import com.business95.api.exception.RolSistemaException;
import com.business95.api.repository.PermisoRepository;
import com.business95.api.service.interfaces.InversionSocioService;
import com.business95.api.service.interfaces.RolService;

@Component("inversionSecurity")
public class InversionSecurity {

    private final PermisoRepository permisoRepository;
    private final InversionSocioService inversionSocioService;
    private final RolService rolService;

    public InversionSecurity(
            PermisoRepository permisoRepository,
            InversionSocioService inversionSocioService,
            RolService rolService) {
        this.permisoRepository = permisoRepository;
        this.inversionSocioService = inversionSocioService;
        this.rolService = rolService;
    }

    public boolean tienePermiso(String permiso, Long idInversion) {

        String rol = inversionSocioService.obtenerRolSocioPorInversion(idInversion);

        if (rolService.esRolSistema(rol)) {
            throw new RolSistemaException();
        }

        return permisoRepository.buscarPorRolYPermiso(rol, permiso).isPresent();
    }

}
