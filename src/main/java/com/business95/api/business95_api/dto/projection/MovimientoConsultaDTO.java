package com.business95.api.business95_api.dto.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimientoConsultaDTO {

    private Long idMovimiento;
    private String concepto;
    private String categoria;
    private String moneda;
    private String medida;
    private String inversion;
    private Long idActividad;
    private String socio;
    private BigDecimal monto;
    private BigDecimal cantidad;
    private LocalDateTime fecha;
    private String tipoActividad;

    public MovimientoConsultaDTO() {
    }

    public MovimientoConsultaDTO(Long idMovimiento, String concepto, String categoria, String moneda, String medida,
            String inversion, Long idActividad, String socio, BigDecimal monto, BigDecimal cantidad,
            LocalDateTime fecha, String tipoActividad) {
        this.idMovimiento = idMovimiento;
        this.concepto = concepto;
        this.categoria = categoria;
        this.moneda = moneda;
        this.medida = medida;
        this.inversion = inversion;
        this.idActividad = idActividad;
        this.socio = socio;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
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
