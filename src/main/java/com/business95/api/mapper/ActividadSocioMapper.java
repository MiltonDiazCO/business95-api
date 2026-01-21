package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.ActividadSocioResponse;
import com.business95.api.entity.ActividadSocio;
import com.business95.api.util.NombreSocioUtil;

@Mapper(componentModel = "spring", uses = { NombreSocioUtil.class })
public interface ActividadSocioMapper {

    @Mapping(source = "socio.idSocio", target = "idSocio")
    @Mapping(source = "socio", target = "socio", qualifiedByName = "nombreSocioCompleto")
    @Mapping(source = "tipoActividad.idTipoActividad", target = "idTipoActividad")
    @Mapping(source = "tipoActividad.tipoActividad", target = "tipoActividad")
    ActividadSocioResponse toActividadSocioResponseDTO(ActividadSocio actividadSocio);

}
