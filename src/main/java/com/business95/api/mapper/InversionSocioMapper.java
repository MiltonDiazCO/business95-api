package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.SocioPorInversionResponse;
import com.business95.api.entity.InversionSocio;
import com.business95.api.util.NombreSocioUtil;

@Mapper(componentModel = "spring", uses = { NombreSocioUtil.class })
public interface InversionSocioMapper {

    @Mapping(source = "socio.idSocio", target = "idSocio")
    @Mapping(source = "socio", target = "socio", qualifiedByName = "nombreSocioCompleto")
    @Mapping(source = "rol.rol", target = "rol")
    @Mapping(source = "socioCreacion.idSocio", target = "idSocioCreacion")
    @Mapping(source = "socioCreacion", target = "socioCreacion", qualifiedByName = "nombreSocioCompleto")
    @Mapping(source = "socioModificacion.idSocio", target = "idSocioModificacion")
    @Mapping(source = "socioModificacion", target = "socioModificacion", qualifiedByName = "nombreSocioCompleto")
    SocioPorInversionResponse toSocioPorInversionResponse(InversionSocio inversionSocio);

}
