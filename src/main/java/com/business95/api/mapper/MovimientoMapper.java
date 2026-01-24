package com.business95.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.dto.response.BalanceMovimientoResponse;
import com.business95.api.dto.response.MovimientoConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoResponse;
import com.business95.api.entity.Movimiento;

@Mapper(componentModel = "spring", uses = { ActividadSocioMapper.class })
public interface MovimientoMapper {

    @Mapping(source = "inversion.idInversion", target = "idInversion")
    @Mapping(source = "inversion.inversion", target = "inversion")
    @Mapping(source = "categoria.idCategoria", target = "idCategoria")
    @Mapping(source = "categoria.categoria", target = "categoria")
    @Mapping(source = "medida.idMedida", target = "idMedida")
    @Mapping(source = "medida.medida", target = "medida")
    @Mapping(source = "moneda.idMoneda", target = "idMoneda")
    @Mapping(source = "moneda.moneda", target = "moneda")
    @Mapping(source = "actividadesSocio", target = "actividades")
    MovimientoResponse toMovimientoResponse(Movimiento movimiento);

    @Mapping(target = "balanceSocios", ignore = true)
    MovimientoConBalancesSociosResponse toMovimientoConBalancesSociosResponse(
            BalanceMovimientoResponse balanceMovimiento);
}
