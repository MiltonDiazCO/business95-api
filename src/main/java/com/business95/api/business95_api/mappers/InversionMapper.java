package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;

import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.entities.Inversion;

@Mapper(componentModel = "spring")
public interface InversionMapper {

    InversionRes toInversionResponse(Inversion inversion);

}
