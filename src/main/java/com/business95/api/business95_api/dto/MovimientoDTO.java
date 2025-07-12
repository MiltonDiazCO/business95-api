package com.business95.api.business95_api.dto;

import java.util.List;

public class MovimientoDTO {

    private Long inversion;
    private String concepto;
    private Long categoria;
    private String moneda;
    private Long medida;
    private List<ActividadDTO> actividades;

    public MovimientoDTO() {
    }

    public MovimientoDTO(Long inversion, String concepto, Long categoria, String moneda, Long medida,
            List<ActividadDTO> actividades) {
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.moneda = moneda;
        this.medida = medida;
        this.actividades = actividades;
    }

    public Long getInversion() {
        return inversion;
    }

    public void setInversion(Long inversion) {
        this.inversion = inversion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Long getMedida() {
        return medida;
    }

    public void setMedida(Long medida) {
        this.medida = medida;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

}
