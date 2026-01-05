package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.ActividadSocioResponse;
import com.business95.api.entity.ActividadSocio;

@Mapper(componentModel = "spring")
public interface ActividadSocioMapper {

    @Mapping(source = "socio.idSocio", target = "idSocio")
    @Mapping(target = "socio", expression = "java(actividadSocio.getSocio().getApellidos() != null ? " +
            "actividadSocio.getSocio().getNombresRazonsocial() + \" \" + actividadSocio.getSocio().getApellidos() : " +
            "actividadSocio.getSocio().getNombresRazonsocial())")
    @Mapping(source = "tipoActividad.idTipoActividad", target = "idTipoActividad")
    @Mapping(source = "tipoActividad.tipoActividad", target = "tipoActividad")
    ActividadSocioResponse toActividadSocioResponseDTO(ActividadSocio actividadSocio);

}
