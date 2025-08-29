package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.SocioResponse;
import com.business95.api.business95_api.entities.Socio;

@Mapper(componentModel = "spring")
public interface SocioMapper {

    @Mapping(target = "socio", expression = "java(socio.getNombresRazonsocial() + \" \" + socio.getApellidos())")
    @Mapping(source = "tipoPersona.tipoPersona", target = "tipoPersona")
    SocioResponse socioToSocioResponseDTO(Socio socio);

}
