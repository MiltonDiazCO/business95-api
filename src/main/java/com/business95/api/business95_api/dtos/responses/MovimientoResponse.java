package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoResponse {

    private Long idMovimiento;
    private Long idInversion;
    private String inversion;
    private String concepto;
    private Long idCategoria;
    private String categoria;
    private Long idMedida;
    private String medida;
    private String idMoneda;
    private String moneda;
    private List<ActividadSocioRes> actividades = new ArrayList<>();

    public MovimientoResponse() {
    }

    public MovimientoResponse(
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
        this.idMovimiento = idMovimiento;
        this.idInversion = idInversion;
        this.inversion = inversion;
        this.concepto = concepto;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.idMedida = idMedida;
        this.medida = medida;
        this.idMoneda = idMoneda;
        this.moneda = moneda;
        this.actividades = actividades;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Long getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(Long idInversion) {
        this.idInversion = idInversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Long idMedida) {
        this.idMedida = idMedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public List<ActividadSocioRes> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadSocioRes> actividades) {
        this.actividades = actividades;
    }

}
