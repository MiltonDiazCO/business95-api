package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.BalanceInversionResponse;
import com.business95.api.business95_api.dtos.responses.BalanceSocioResponse;
import com.business95.api.business95_api.dtos.responses.InversionResponse;
import com.business95.api.business95_api.dtos.responses.InversionConSociosResponse;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.projections.BalanceInversionProjection;
import com.business95.api.business95_api.projections.BalanceSocioPorInvProjection;

@Mapper(componentModel = "spring", uses = { SocioMapper.class })
public interface InversionMapper {

    InversionResponse toInversionResponse(Inversion inversion);

    InversionConSociosResponse toInversionConSociosResponse(Inversion inversion);

    @Mapping(target = "balancesPorSocio", ignore = true)
    BalanceInversionResponse toBalanceInversionResponse(BalanceInversionProjection balanceInversionProjection);

    BalanceSocioResponse toBalanceSocioPorInvResponse(BalanceSocioPorInvProjection balanceSocioPorInvProjection);

}
