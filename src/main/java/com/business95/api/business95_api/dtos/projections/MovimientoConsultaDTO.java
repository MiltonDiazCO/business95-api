package com.business95.api.business95_api.dtos.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimientoConsultaDTO {

    private Long idMovimiento;
    private String inversion;
    private String concepto;
    private String categoria;
    private String medida;
    private String moneda;
    private Long idActividad;
    private String socio;
    private BigDecimal cantidad;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String tipoActividad;

    public MovimientoConsultaDTO() {
    }

    public MovimientoConsultaDTO(Long idMovimiento, String inversion, String concepto, String categoria, String medida,
            String moneda, Long idActividad, String socio, BigDecimal cantidad, BigDecimal monto, LocalDateTime fecha,
            String tipoActividad) {
        this.idMovimiento = idMovimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.medida = medida;
        this.moneda = moneda;
        this.idActividad = idActividad;
        this.socio = socio;
        this.cantidad = cantidad;
        this.monto = monto;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
