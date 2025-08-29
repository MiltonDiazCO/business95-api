package com.business95.api.business95_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.business95.api.business95_api.dtos.responses.MovimientoPorInversionResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoUpdateResponse;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.projections.MovimientoPorInversionProjection;

@Mapper(componentModel = "spring", uses = { ActividadSocioMapper.class })
public interface MovimientoMapper {

    @Mapping(source = "inversion.inversion", target = "inversion")
    @Mapping(source = "categoria.categoria", target = "categoria")
    @Mapping(source = "medida.medida", target = "medida")
    @Mapping(source = "moneda.moneda", target = "moneda")
    @Mapping(source = "actividadesSocio", target = "actividades")
    MovimientoResponse movimientoToMovimientoResponseDTO(Movimiento movimiento);

    @Mapping(source = "inversion.inversion", target = "inversion")
    @Mapping(source = "categoria.categoria", target = "categoria")
    @Mapping(source = "medida.medida", target = "medida")
    @Mapping(source = "moneda.moneda", target = "moneda")
    MovimientoUpdateResponse movimientoToMovimientoUpdateResponseDTO(Movimiento movimiento);

    @Mapping(target = "inversion", ignore = true)
    MovimientoPorInversionResponseDTO movimientoPorInversionProjectionTOMovimientoPorInversionResponseDTO(
            MovimientoPorInversionProjection movimientoPorInversionProjection);
}
