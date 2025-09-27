package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.BalanceInversionRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioPorInvRes;
import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.dtos.responses.InversionSociosRes;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.projections.BalanceInversionProjection;
import com.business95.api.business95_api.projections.BalanceSocioPorInvProjection;

@Mapper(componentModel = "spring", uses = { SocioMapper.class })
public interface InversionMapper {

    InversionRes toInversionResponse(Inversion inversion);

    @Mapping(source = "socios", target = "sociosResponse")
    InversionSociosRes toInversionSociosRes(Inversion inversion);

    @Mapping(target = "balances", ignore = true)
    BalanceInversionRes toBalanceInversionResponse(BalanceInversionProjection balanceInversionProjection);

    BalanceSocioPorInvRes toBalanceSocioPorInvResponse(BalanceSocioPorInvProjection balanceSocioPorInvProjection);

}
