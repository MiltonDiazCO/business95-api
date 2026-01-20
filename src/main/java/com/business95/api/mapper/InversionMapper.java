package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.BalanceInversionResponse;
import com.business95.api.dto.response.BalanceSocioPorInversionResponse;
import com.business95.api.dto.response.InversionConSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.entity.Inversion;
import com.business95.api.projection.BalanceInversionProjection;
import com.business95.api.projection.BalanceSocioPorInversionProjection;

@Mapper(componentModel = "spring", uses = { SocioMapper.class })
public interface InversionMapper {

    InversionResponse toInversionResponse(Inversion inversion);

    InversionConSociosResponse toInversionConSociosResponse(Inversion inversion);

    @Mapping(target = "balancesPorSocio", ignore = true)
    BalanceInversionResponse toBalanceInversionResponse(BalanceInversionProjection balanceInversionProjection);

    BalanceSocioPorInversionResponse toBalanceSocioPorInversionResponse(BalanceSocioPorInversionProjection balanceSocioPorInvProjection);

}
