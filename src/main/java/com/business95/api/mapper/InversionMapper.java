package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.entity.Inversion;
import com.business95.api.projection.BalanceInversionProjection;

@Mapper(componentModel = "spring", uses = { SocioMapper.class })
public interface InversionMapper {

    InversionResponse toInversionResponse(Inversion inversion);

    @Mapping(target = "socios", ignore = true)
    InversionConSociosResponse toInversionConSociosResponse(Inversion inversion);

    @Mapping(target = "balancesPorSocio", ignore = true)
    InversionConBalancesSociosResponse toBalanceInversionResponse(
            BalanceInversionProjection balanceInversionProjection);

}
