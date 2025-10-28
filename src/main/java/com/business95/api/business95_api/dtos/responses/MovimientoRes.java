package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idMovimiento", "idInversion", "inversion", "idInversion", "concepto",
        "idCategoria", "categoria", "idMedida", "medida", "idMoneda", "moneda", "actividades" })
public class MovimientoRes extends DetalleMovimiento {

    private Long idInversion;
    private Long idCategoria;
    private Long idMedida;
    private String idMoneda;
    private List<ActividadSocioRes> actividades = new ArrayList<>();

    public MovimientoRes() {
    }

    public MovimientoRes(List<ActividadSocioRes> actividades) {
        this.actividades = actividades;
    }

    public MovimientoRes(
            Long idMovimiento,
            Long idInversion,
            String inversion,
            String concepto,
            Long idCategoria,
            String categoria,
            Long idMedida,
            String medida,
            String idMoneda,
            String moneda,
            List<ActividadSocioRes> actividades) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.idInversion = idInversion;
        this.idCategoria = idCategoria;
        this.idMedida = idMedida;
        this.idMoneda = idMoneda;
        this.actividades = actividades;
    }

    public Long getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(Long idInversion) {
        this.idInversion = idInversion;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Long idMedida) {
        this.idMedida = idMedida;
    }

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public List<ActividadSocioRes> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadSocioRes> actividades) {
        this.actividades = actividades;
    }

    public void addActividadSocio(ActividadSocioRes actividadSocioResponse) {
        this.actividades.add(actividadSocioResponse);
    }

}
