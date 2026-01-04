package com.business95.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dtos.responses.BalanceAnualSocioResponse;
import com.business95.api.dtos.responses.BalanceSocioResponse;
import com.business95.api.dtos.responses.SocioResponse;
import com.business95.api.entities.Socio;
import com.business95.api.projections.BalanceAnualSocioProjection;
import com.business95.api.projections.BalanceSocioProjection;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class })
public interface SocioMapper {

    @Mapping(target = "socio", expression = "java(socio.getNombresRazonsocial() + (socio.getApellidos() != null ? \" \" + socio.getApellidos() : \"\"))")
    @Mapping(source = "tipoPersona.tipoPersona", target = "tipoPersona")
    @Mapping(source = "usuario", target = "usuario")
    SocioResponse toSocioResponseDTO(Socio socio);

    @Mapping(target = "historialAnual", ignore = true)
    BalanceSocioResponse toBalanceSocioResponse(BalanceSocioProjection balanceSocioProjection);

    BalanceAnualSocioResponse toBalanceAnualSocioResponse(BalanceAnualSocioProjection balanceAnualSocioProjection);

}
