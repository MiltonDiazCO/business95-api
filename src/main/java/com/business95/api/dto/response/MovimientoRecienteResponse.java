package com.business95.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoRecienteResponse {

    private Long idMovimiento;
    private Long idInversion;
    private String inversion;
    private String concepto;
    private String categoria;
    private BigDecimal cantidad;
    private String medida;
    private BigDecimal balance;
    private String moneda;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaUltimaActividad;

    public MovimientoRecienteResponse() {
    }

    public MovimientoRecienteResponse(
            Long idMovimiento,
            Long idInversion,
            String inversion,
            String concepto,
            String categoria,
            BigDecimal cantidad,
            String medida,
            BigDecimal balance,
            String moneda,
            LocalDateTime fechaApertura,
            LocalDateTime fechaUltimaActividad) {
        this.idMovimiento = idMovimiento;
        this.idInversion = idInversion;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.medida = medida;
        this.balance = balance;
        this.moneda = moneda;
        this.fechaApertura = fechaApertura;
        this.fechaUltimaActividad = fechaUltimaActividad;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDateTime getFechaUltimaActividad() {
        return fechaUltimaActividad;
    }

    public void setFechaUltimaActividad(LocalDateTime fechaUltimaActividad) {
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

}
