package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.MovimientoUpdateResponseDTO;
import com.business95.api.business95_api.entities.Movimiento;

@Mapper(componentModel = "spring")
public interface MovimientoUpdateMapper {

    @Mapping(source = "inversion.inversion", target = "inversion")
    @Mapping(source = "categoria.categoria", target = "categoria")
    @Mapping(source = "medida.medida", target = "medida")
    @Mapping(source = "moneda.moneda", target = "moneda")
    MovimientoUpdateResponseDTO movimientoToMovimientoUpdateResponseDTO(Movimiento movimiento);

}
