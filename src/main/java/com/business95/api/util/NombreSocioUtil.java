package com.business95.api.util;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.business95.api.entity.Socio;

@Component
public class NombreSocioUtil {

    @Named("nombreSocioCompleto")
    public String nombreSocioCompleto(Socio socio) {
        if (socio == null)
            return null;

        String apellidos = socio.getApellidos();

        return apellidos == null || apellidos.isEmpty()
                ? socio.getNombresRazonsocial()
                : socio.getNombresRazonsocial() + " " + socio.getApellidos();
    }

}
