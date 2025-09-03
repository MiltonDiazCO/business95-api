package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoRes extends DetalleMovimiento {

    private List<ActividadSocioRes> actividades = new ArrayList<>();

    public MovimientoRes() {
    }

    public MovimientoRes(List<ActividadSocioRes> actividades) {
        this.actividades = actividades;
    }

    public MovimientoRes(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            List<ActividadSocioRes> actividades) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.actividades = actividades;
    }

    public void addActividadSocio(ActividadSocioRes actividadSocioResponse) {
        this.actividades.add(actividadSocioResponse);
    }

    public List<ActividadSocioRes> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadSocioRes> actividades) {
        this.actividades = actividades;
    }

}
