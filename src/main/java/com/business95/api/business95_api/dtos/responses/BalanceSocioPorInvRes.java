package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;

public class BalanceSocioPorInvRes {

    private String socio;
    private BigDecimal ingresos;
    private BigDecimal gastos;
    private BigDecimal balanceSocio;

    public BalanceSocioPorInvRes() {
    }

    public BalanceSocioPorInvRes(String socio, BigDecimal ingresos, BigDecimal gastos, BigDecimal balanceSocio) {
        this.socio = socio;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balanceSocio = balanceSocio;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    public BigDecimal getGastos() {
        return gastos;
    }

    public void setGastos(BigDecimal gastos) {
        this.gastos = gastos;
    }

    public BigDecimal getBalanceSocio() {
        return balanceSocio;
    }

    public void setBalanceSocio(BigDecimal balanceSocio) {
        this.balanceSocio = balanceSocio;
    }

}
