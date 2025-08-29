package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoResponse extends DetalleMovimiento {

    private List<ActividadSocioResponse> actividades = new ArrayList<>();

    public MovimientoResponse() {
    }

    public MovimientoResponse(List<ActividadSocioResponse> actividades) {
        this.actividades = actividades;
    }

    public MovimientoResponse(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            List<ActividadSocioResponse> actividades) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.actividades = actividades;
    }

    public void addActividadSocio(ActividadSocioResponse actividadSocioResponse) {
        this.actividades.add(actividadSocioResponse);
    }

    public List<ActividadSocioResponse> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadSocioResponse> actividades) {
        this.actividades = actividades;
    }

}
