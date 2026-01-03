package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceMovsPorInvRes {

    private Long idMovimiento;
    private String inversion;
    private String concepto;
    private String categoria;
    private BigDecimal cantidadMovimiento;
    private String medida;
    private BigDecimal balanceMovimiento;
    private String moneda;
    private LocalDateTime fechaUltimaActividad;

    public BalanceMovsPorInvRes() {
    }

    public BalanceMovsPorInvRes(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            BigDecimal cantidadMovimiento,
            String medida,
            BigDecimal balanceMovimiento,
            String moneda,
            LocalDateTime fechaUltimaActividad) {
        this.idMovimiento = idMovimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.cantidadMovimiento = cantidadMovimiento;
        this.medida = medida;
        this.balanceMovimiento = balanceMovimiento;
        this.moneda = moneda;
        this.fechaUltimaActividad = fechaUltimaActividad;
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

    public BigDecimal getCantidadMovimiento() {
        return cantidadMovimiento;
    }

    public void setCantidadMovimiento(BigDecimal cantidadMovimiento) {
        this.cantidadMovimiento = cantidadMovimiento;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getBalanceMovimiento() {
        return balanceMovimiento;
    }

    public void setBalanceMovimiento(BigDecimal balanceMovimiento) {
        this.balanceMovimiento = balanceMovimiento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public LocalDateTime getFechaUltimaActividad() {
        return fechaUltimaActividad;
    }

    public void setFechaUltimaActividad(LocalDateTime fechaUltimaActividad) {
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

}
