package com.business95.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dtos.responses.BalanceInversionResponse;
import com.business95.api.dtos.responses.BalanceSocioResponse;
import com.business95.api.dtos.responses.InversionResponse;
import com.business95.api.dtos.responses.InversionConSociosResponse;
import com.business95.api.entities.Inversion;
import com.business95.api.projections.BalanceInversionProjection;
import com.business95.api.projections.BalanceSocioPorInvProjection;

@Mapper(componentModel = "spring", uses = { SocioMapper.class })
public interface InversionMapper {

    InversionResponse toInversionResponse(Inversion inversion);

    InversionConSociosResponse toInversionConSociosResponse(Inversion inversion);

    @Mapping(target = "balancesPorSocio", ignore = true)
    BalanceInversionResponse toBalanceInversionResponse(BalanceInversionProjection balanceInversionProjection);

    BalanceSocioResponse toBalanceSocioPorInvResponse(BalanceSocioPorInvProjection balanceSocioPorInvProjection);

}
