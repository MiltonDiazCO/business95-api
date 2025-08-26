package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.ActividadSocioResponseDTO;
import com.business95.api.business95_api.entities.ActividadSocio;

@Mapper(componentModel = "spring")
public interface ActividadSocioMapper {

    @Mapping(target = "socio", expression = "java(actividadSocio.getSocio().getNombresRazonsocial() + \" \" + actividadSocio.getSocio().getApellidos())")
    @Mapping(source = "tipoActividad.tipoActividad", target = "tipoActividad")
    ActividadSocioResponseDTO actividadSocioToActividadSocioResponseDTO(ActividadSocio actividadSocio);

}
