package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.InversionSocio;
import com.business95.api.entity.Rol;
import com.business95.api.entity.Socio;
import com.business95.api.exception.InversionSocioNoEncontradoException;
import com.business95.api.repository.InversionSocioRepository;
import com.business95.api.security.context.SocioActual;

@Component
public class InversionSocioHelper {

    private InversionSocioRepository inversionSocioRepository;
    private SocioHelper socioHelper;
    private SocioActual socioActual;

    public InversionSocioHelper(
            InversionSocioRepository inversionSocioRepository,
            SocioHelper socioHelper,
            SocioActual socioActual) {
        this.inversionSocioRepository = inversionSocioRepository;
        this.socioHelper = socioHelper;
        this.socioActual = socioActual;
    }

    public InversionSocio buscarInversionSocioOLanzarExcepcion(Long idInversion, Long idSocio) {
        return inversionSocioRepository.buscarPorInversionYSocio(idInversion, idSocio)
                .orElseThrow(() -> new InversionSocioNoEncontradoException());
    }

    public InversionSocio construirInversionSocio(Socio socio, Rol rol) {

        InversionSocio inversionSocio = new InversionSocio();

        Socio socioAuditor = socioHelper.buscarPorIdOLanzarExcepcion(socioActual.getIdSocioActual());
        Socio socioCreacion = socioAuditor;
        Socio socioModificacion = socioAuditor;

        inversionSocio.setSocio(socio);
        inversionSocio.setRol(rol);
        inversionSocio.setSocioCreacion(socioCreacion);
        inversionSocio.setSocioModificacion(socioModificacion);

        return inversionSocio;
    }

}
