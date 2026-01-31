package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.BalanceAnualSocioResponse;
import com.business95.api.dto.response.BalanceSocioPorInversionResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.SocioResponse;
import com.business95.api.dto.response.SocioRolInversionResponse;
import com.business95.api.entity.InversionSocio;
import com.business95.api.entity.Socio;
import com.business95.api.projection.BalanceAnualSocioProjection;
import com.business95.api.projection.BalanceSocioPorInversionProjection;
import com.business95.api.projection.BalanceSocioProjection;
import com.business95.api.util.NombreSocioUtil;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class, NombreSocioUtil.class })
public interface SocioMapper {

        @Mapping(source = "socio", target = "socio", qualifiedByName = "nombreSocioCompleto")
        @Mapping(source = "tipoPersona.tipoPersona", target = "tipoPersona")
        @Mapping(source = "usuario.correoElectronico", target = "correoElectronico")
        @Mapping(source = "usuario", target = "detalleUsuario")
        SocioResponse toSocioResponseDTO(Socio socio);

        @Mapping(source = "socio", target = "socio", qualifiedByName = "nombreSocioCompleto")
        SocioNombresResponse toSocioNombresResponse(Socio socio);

        @Mapping(target = "historialAnual", ignore = true)
        BalanceSocioResponse toBalanceSocioResponse(BalanceSocioProjection balanceSocioProjection);

        @Mapping(source = "socio.idSocio", target = "idSocio")
        @Mapping(source = "socio", target = "socio", qualifiedByName = "nombreSocioCompleto")
        @Mapping(source = "rol.rol", target = "rol")
        @Mapping(source = "socioCreacion.idSocio", target = "idSocioCreacion")
        @Mapping(source = "socioCreacion", target = "socioCreacion", qualifiedByName = "nombreSocioCompleto")
        @Mapping(source = "socioModificacion.idSocio", target = "idSocioModificacion")
        @Mapping(source = "socioModificacion", target = "socioModificacion", qualifiedByName = "nombreSocioCompleto")
        SocioRolInversionResponse toSocioRolInversionResponse(InversionSocio inversionSocio);

        BalanceAnualSocioResponse toBalanceAnualSocioResponse(
                        BalanceAnualSocioProjection balanceAnualSocioProjection);

        BalanceSocioPorInversionResponse toBalanceSocioPorInversionResponse(
                        BalanceSocioPorInversionProjection balanceSocioPorInvProjection);

}
