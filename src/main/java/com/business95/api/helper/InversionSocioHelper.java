package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.InversionSocio;
import com.business95.api.entity.Rol;
import com.business95.api.entity.Socio;

@Component
public class InversionSocioHelper {

    public InversionSocio construirInversionSocio(
            Socio socio,
            Rol rol,
            Socio socioCreacion,
            Socio socioModificacion) {

        InversionSocio inversionSocio = new InversionSocio();

        inversionSocio.setSocio(socio);
        inversionSocio.setRol(rol);
        inversionSocio.setSocioCreacion(socioCreacion);
        inversionSocio.setSocioModificacion(socioModificacion);

        return inversionSocio;
    }

}
