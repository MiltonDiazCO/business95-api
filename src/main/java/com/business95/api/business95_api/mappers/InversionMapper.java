package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;

import com.business95.api.business95_api.dtos.responses.InversionResponse;
import com.business95.api.business95_api.entities.Inversion;

@Mapper
public interface InversionMapper {

    InversionResponse toInversionResponse(Inversion inversion);

}
