package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Socio;
import com.business95.api.exception.SocioNoEncontradoException;
import com.business95.api.repository.SocioRepository;

@Component
public class SocioHelper {

    private SocioRepository socioRepository;
    private TipoPersonaHelper tipoPersonaHelper;

    public SocioHelper(SocioRepository socioRepository, TipoPersonaHelper tipoPersonaHelper) {
        this.socioRepository = socioRepository;
        this.tipoPersonaHelper = tipoPersonaHelper;
    }

    public Socio buscarPorIdOLanzarExcepcion(Long idSocio) {
        return socioRepository.findById(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));
    }

    public Socio construirSocio(
            Long idSocio,
            String nombresRazonsocial,
            String apellidos,
            String telefono,
            Long tipoPersona) {

        Socio socio = new Socio();

        if (idSocio != null) {
            socio = buscarPorIdOLanzarExcepcion(idSocio);
        }

        socio.setNombresRazonsocial(nombresRazonsocial);
        socio.setApellidos(apellidos);
        socio.setTelefono(telefono);
        socio.setTipoPersona(tipoPersonaHelper.buscarPorIdOLanzarExcepcion(tipoPersona));

        return socio;
    }

}
