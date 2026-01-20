package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.BalanceAnualSocioResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;
import com.business95.api.entity.Socio;
import com.business95.api.projection.BalanceAnualSocioProjection;
import com.business95.api.projection.BalanceSocioProjection;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class })
public interface SocioMapper {

    @Mapping(target = "socio", expression = "java(socio.getNombresRazonsocial() + (socio.getApellidos() != null ? \" \" + socio.getApellidos() : \"\"))")
    @Mapping(source = "tipoPersona.tipoPersona", target = "tipoPersona")
    @Mapping(source = "usuario.correoElectronico", target = "correoElectronico")
    @Mapping(source = "usuario", target = "detalleUsuario")
    SocioResponse toSocioResponseDTO(Socio socio);

    @Mapping(target = "historialAnual", ignore = true)
    BalanceSocioResponse toBalanceSocioResponse(BalanceSocioProjection balanceSocioProjection);

    BalanceAnualSocioResponse toBalanceAnualSocioResponse(BalanceAnualSocioProjection balanceAnualSocioProjection);

}
