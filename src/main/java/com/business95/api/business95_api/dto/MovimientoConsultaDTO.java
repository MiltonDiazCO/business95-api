package com.business95.api.business95_api.dto;

import java.util.List;

public class MovimientoConsultaDTO {

    private String inversion;
    private String concepto;
    private String categoria;
    private String moneda;
    private String medida;
    private List<ActividadConsultaDTO> actividades;

    public MovimientoConsultaDTO() {
    }

    public MovimientoConsultaDTO(String inversion, String concepto, String categoria, String moneda, String medida,
            List<ActividadConsultaDTO> actividades) {
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.moneda = moneda;
        this.medida = medida;
        this.actividades = actividades;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public List<ActividadConsultaDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadConsultaDTO> actividades) {
        this.actividades = actividades;
    }

}
