package com.business95.api.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.PaginaResponse;
import com.business95.api.dto.response.SocioPorInversionResponse;
import com.business95.api.entity.Inversion;
import com.business95.api.entity.InversionSocio;
import com.business95.api.entity.Rol;
import com.business95.api.entity.Socio;
import com.business95.api.exception.InversionSinSociosException;
import com.business95.api.exception.SociosRequeridosException;
import com.business95.api.helper.InversionHelper;
import com.business95.api.helper.InversionSocioHelper;
import com.business95.api.helper.RolHelper;
import com.business95.api.helper.SocioHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.mapper.InversionSocioMapper;
import com.business95.api.repository.InversionRepository;
import com.business95.api.repository.InversionSocioRepository;
import com.business95.api.security.context.SocioActual;
import com.business95.api.service.interfaces.InversionSocioService;

@Service
public class InversionSocioServiceImpl implements InversionSocioService {

    private final InversionSocioRepository inversionSocioRepository;
    private final InversionRepository inversionRepository;
    private final InversionSocioHelper inversionSocioHelper;
    private final InversionHelper inversionHelper;
    private final SocioHelper socioHelper;
    private final RolHelper rolHelper;
    private final InversionMapper inversionMapper;
    private final SocioActual socioActual;

    public InversionSocioServiceImpl(
            InversionSocioRepository inversionSocioRepository,
            InversionRepository inversionRepository,
            InversionSocioHelper inversionSocioHelper,
            InversionHelper inversionHelper,
            SocioHelper socioHelper,
            RolHelper rolHelper,
            InversionSocioMapper inversionSocioMapper,
            InversionMapper inversionMapper,
            SocioActual socioActual) {
        this.inversionSocioRepository = inversionSocioRepository;
        this.inversionRepository = inversionRepository;
        this.inversionSocioHelper = inversionSocioHelper;
        this.inversionHelper = inversionHelper;
        this.socioHelper = socioHelper;
        this.rolHelper = rolHelper;
        this.inversionMapper = inversionMapper;
        this.socioActual = socioActual;
    }

    @Override
    public PaginaResponse<SocioPorInversionResponse> sociosPorInversion(Long idInversion, Pageable pageable) {
        return new PaginaResponse<>(inversionSocioRepository.buscarByinversionIdInversion(idInversion, pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public String obtenerRolSocioPorInversion(Long idInversion) {
        return inversionSocioHelper
                .buscarInversionSocioOLanzarExcepcion(idInversion, socioActual.getIdSocioActual())
                .getRol().getRol();
    }

    @Override
    @Transactional()
    @PreAuthorize("""
                @inversionSecurity.esNuevainversion(#idInversion)
                || @inversionSecurity.tienePermiso('AGREGAR_SOCIOS_A_INVERSION', #idInversion)
            """)
    public InversionConSociosResponse agregarSociosAInversion(
            Long idInversion,
            Set<SocioRolInversionRequest> socios) {

        Inversion inversion = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        if (socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (SocioRolInversionRequest socioRol : socios) {
            Socio socio = socioHelper.buscarPorIdOLanzarExcepcion(socioRol.getIdSocio());
            Rol rol = rolHelper.buscarPorRolOLanzarExcepcion(socioRol.getRol());

            inversion.addSocio(inversionSocioHelper.construirInversionSocio(socio, rol));
        }

        return inversionMapper.toInversionConSociosResponse(inversionRepository.save(inversion));
    }

    @Override
    @Transactional
    @PreAuthorize("@inversionSecurity.tienePermiso('MODIFICAR_ROL_SOCIO_POR_INVERSION', #idInversion)")
    public InversionConSociosResponse modificarRolesDeSociosEnInversion(
            Long idInversion,
            Set<SocioRolInversionRequest> socios) {

        if (socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (SocioRolInversionRequest socioRol : socios) {
            InversionSocio inversionSocio = inversionSocioHelper
                    .buscarInversionSocioOLanzarExcepcion(idInversion, socioRol.getIdSocio());

            inversionSocio.setFechaModificacion(LocalDateTime.now());

            inversionSocio.setSocioModificacion(
                    socioHelper.buscarPorIdOLanzarExcepcion(socioActual.getIdSocioActual()));

            inversionSocio.setRol(rolHelper.buscarPorRolOLanzarExcepcion(socioRol.getRol()));

            inversionSocioRepository.save(inversionSocio);

        }

        return inversionMapper.toInversionConSociosResponse(
                inversionHelper.buscarPorIdOLanzarExcepcion(idInversion));
    }

    @Override
    @Transactional()
    @PreAuthorize("@inversionSecurity.tienePermiso('ELIMINAR_SOCIOS_DE_INVERSION', #idInversion)")
    public void eliminarSociosDeInversion(Long idInversion, List<Long> socios) {

        Inversion inversion = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        if (socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        if (socios.size() >= inversion.getSocios().size()) {
            throw new InversionSinSociosException();
        }

        for (Long idSocio : socios) {
            inversion.removeSocio(inversionSocioHelper
                    .buscarInversionSocioOLanzarExcepcion(idInversion, idSocio));
        }
    }

}
