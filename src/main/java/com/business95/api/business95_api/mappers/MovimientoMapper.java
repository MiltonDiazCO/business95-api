package com.business95.api.business95_api.mappers;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.business95.api.business95_api.dtos.responses.MovimientoRes;
import com.business95.api.business95_api.entities.Movimiento;

@Mapper(componentModel = "spring", uses = { ActividadSocioMapper.class })
public interface MovimientoMapper {

    @Mapping(source = "inversion.inversion", target = "inversion")
    @Mapping(source = "categoria.categoria", target = "categoria")
    @Mapping(source = "medida.medida", target = "medida")
    @Mapping(source = "moneda.moneda", target = "moneda")
    DetalleMovimiento toDetalleMovimiento(Movimiento movimiento);

    @InheritConfiguration(name = "toDetalleMovimiento")
    @Mapping(source = "inversion.idInversion", target = "idInversion")
    @Mapping(source = "categoria.idCategoria", target = "idCategoria")
    @Mapping(source = "medida.idMedida", target = "idMedida")
    @Mapping(source = "moneda.idMoneda", target = "idMoneda")
    @Mapping(source = "actividadesSocio", target = "actividades")
    MovimientoRes toMovimientoResponse(Movimiento movimiento);
}
