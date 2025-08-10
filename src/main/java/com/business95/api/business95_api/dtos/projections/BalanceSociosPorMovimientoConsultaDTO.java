package com.business95.api.business95_api.dtos.projections;

import java.math.BigDecimal;

public class BalanceSociosPorMovimientoConsultaDTO {

    private Long idMovimiento;
    private String inversion;
    private String concepto;
    private String categoria;
    private String medida;
    private String moneda;
    private String socio;
    private BigDecimal cantidad;
    private BigDecimal balanceMonetario;

    public BalanceSociosPorMovimientoConsultaDTO() {
    }

    public BalanceSociosPorMovimientoConsultaDTO(Long idMovimiento, String inversion, String concepto, String categoria,
            String medida, String moneda, String socio, BigDecimal cantidad, BigDecimal balanceMonetario) {
        this.idMovimiento = idMovimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.medida = medida;
        this.moneda = moneda;
        this.socio = socio;
        this.cantidad = cantidad;
        this.balanceMonetario = balanceMonetario;
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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getBalanceMonetario() {
        return balanceMonetario;
    }

    public void setBalanceMonetario(BigDecimal balanceMonetario) {
        this.balanceMonetario = balanceMonetario;
    }

}
