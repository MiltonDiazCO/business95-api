package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimientoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoResponseDTO extends DetalleMovimientoDTO {

    private List<ActividadSocioResponseDTO> actividades = new ArrayList<>();

    public MovimientoResponseDTO() {
    }

    public MovimientoResponseDTO(List<ActividadSocioResponseDTO> actividades) {
        this.actividades = actividades;
    }

    public MovimientoResponseDTO(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            List<ActividadSocioResponseDTO> actividades) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.actividades = actividades;
    }

    public void addActividadSocio(ActividadSocioResponseDTO actividadSocioResponseDTO) {
        this.actividades.add(actividadSocioResponseDTO);
    }

    public List<ActividadSocioResponseDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadSocioResponseDTO> actividades) {
        this.actividades = actividades;
    }

}
