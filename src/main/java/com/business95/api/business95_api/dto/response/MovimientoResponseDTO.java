package com.business95.api.business95_api.dto.response;

import java.util.ArrayList;
import java.util.List;

public class MovimientoResponseDTO {

    private Long idMovimiento;
    private String concepto;
    private String categoria;
    private String moneda;
    private String medida;
    private String inversion;
    private List<ActividadResponseDTO> actividadesSocio = new ArrayList<>();

    public MovimientoResponseDTO() {
    }

    public MovimientoResponseDTO(Long idMovimiento, String concepto, String categoria, String moneda, String medida,
            String inversion, List<ActividadResponseDTO> actividadesSocio) {
        this.idMovimiento = idMovimiento;
        this.concepto = concepto;
        this.categoria = categoria;
        this.moneda = moneda;
        this.medida = medida;
        this.inversion = inversion;
        this.actividadesSocio = actividadesSocio;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
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

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public List<ActividadResponseDTO> getActividadesSocio() {
        return actividadesSocio;
    }

    public void setActividadesSocio(List<ActividadResponseDTO> actividadesSocio) {
        this.actividadesSocio = actividadesSocio;
    }

    public void addActividadSocio(ActividadResponseDTO actividadResponseDTO) {
        this.actividadesSocio.add(actividadResponseDTO);
    }

}
