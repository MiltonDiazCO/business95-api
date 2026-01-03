package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;

public class BalanceSocioPorMovRes {

    private Long idMovimiento;
    private String inversion;
    private String concepto;
    private String categoria;
    private String medida;
    private String moneda;
    private String socio;
    private BigDecimal cantidadSocio;
    private BigDecimal balanceSocio;

    public BalanceSocioPorMovRes() {
    }

    public BalanceSocioPorMovRes(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            String socio,
            BigDecimal cantidadSocio,
            BigDecimal balanceSocio) {
        this.idMovimiento = idMovimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.medida = medida;
        this.moneda = moneda;
        this.socio = socio;
        this.cantidadSocio = cantidadSocio;
        this.balanceSocio = balanceSocio;
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

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public BigDecimal getCantidadSocio() {
        return cantidadSocio;
    }

    public void setCantidadSocio(BigDecimal cantidadSocio) {
        this.cantidadSocio = cantidadSocio;
    }

    public BigDecimal getBalanceSocio() {
        return balanceSocio;
    }

    public void setBalanceSocio(BigDecimal balanceSocio) {
        this.balanceSocio = balanceSocio;
    }

}
