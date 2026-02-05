package com.business95.api.service.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.entity.Inversion;
import com.business95.api.entity.Rol;
import com.business95.api.entity.Socio;
import com.business95.api.exception.SociosRequeridosException;
import com.business95.api.helper.InversionHelper;
import com.business95.api.helper.InversionSocioHelper;
import com.business95.api.helper.RolHelper;
import com.business95.api.helper.SocioHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.repository.InversionRepository;
import com.business95.api.service.interfaces.InversionSocioService;

@Service
public class InversionSocioServiceImpl implements InversionSocioService {

    private final InversionRepository inversionRepository;
    private final InversionSocioHelper inversionSocioHelper;
    private final InversionHelper inversionHelper;
    private final SocioHelper socioHelper;
    private final RolHelper rolHelper;
    private final InversionMapper inversionMapper;

    public InversionSocioServiceImpl(
            InversionRepository inversionRepository,
            InversionSocioHelper inversionSocioHelper,
            InversionHelper inversionHelper,
            SocioHelper socioHelper,
            RolHelper rolHelper,
            InversionMapper inversionMapper) {
        this.inversionRepository = inversionRepository;
        this.inversionSocioHelper = inversionSocioHelper;
        this.inversionHelper = inversionHelper;
        this.socioHelper = socioHelper;
        this.rolHelper = rolHelper;
        this.inversionMapper = inversionMapper;
    }

    @Override
    @Transactional()
    public InversionConSociosResponse agregarSociosAInversion(
            Long idInversion,
            Set<SocioRolInversionRequest> socios) {

        Inversion inversion = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        if (socios.size() <= 0 || socios.isEmpty()) {
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
    @Transactional()
    public void eliminarSociosDeInversion(Long idInversion, List<Long> socios) {

        Inversion inversion = inversionHelper.buscarPorIdOLanzarExcepcion(idInversion);

        if (socios.size() <= 0 || socios.isEmpty()) {
            throw new SociosRequeridosException();
        }

        for (Long idSocio : socios) {
            inversion.removeSocio(inversionSocioHelper.buscarPorIdOLanzarExcepcion(idInversion, idSocio));
        }
    }

}
