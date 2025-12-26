package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.BalanceAnualSocioRes;
import com.business95.api.business95_api.dtos.responses.BalanceSocioRes;
import com.business95.api.business95_api.dtos.responses.SocioRes;
import com.business95.api.business95_api.entities.Socio;
import com.business95.api.business95_api.projections.BalanceAnualSocioProjection;
import com.business95.api.business95_api.projections.BalanceSocioProjection;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class })
public interface SocioMapper {

    @Mapping(target = "socio", expression = "java(socio.getNombresRazonsocial() + \" \" + socio.getApellidos())")
    @Mapping(source = "tipoPersona.tipoPersona", target = "tipoPersona")
    @Mapping(source = "usuario", target = "usuario")
    SocioRes toSocioResponseDTO(Socio socio);

    @Mapping(target = "balances", ignore = true)
    BalanceSocioRes toBalanceSocioResponse(BalanceSocioProjection balanceSocioProjection);

    BalanceAnualSocioRes toBalanceAnualSocioResponse(BalanceAnualSocioProjection balanceAnualSocioProjection);

}
