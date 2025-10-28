package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.ActividadSocioRes;
import com.business95.api.business95_api.entities.ActividadSocio;

@Mapper(componentModel = "spring")
public interface ActividadSocioMapper {

    @Mapping(source = "socio.idSocio", target = "idSocio")
    @Mapping(target = "socio", expression = "java(actividadSocio.getSocio().getApellidos() != null ? " +
            "actividadSocio.getSocio().getNombresRazonsocial() + \" \" + actividadSocio.getSocio().getApellidos() : " +
            "actividadSocio.getSocio().getNombresRazonsocial())")
    @Mapping(source = "tipoActividad.idTipoActividad", target = "idTipoActividad")
    @Mapping(source = "tipoActividad.tipoActividad", target = "tipoActividad")
    ActividadSocioRes toActividadSocioResponseDTO(ActividadSocio actividadSocio);

}
