package com.business95.api.dtos.responses;

import java.math.BigDecimal;

public class BalanceAnualSocioResponse {

    private Integer annio;
    private BigDecimal ingresos;
    private BigDecimal gastos;
    private BigDecimal balanceAnual;

    public BalanceAnualSocioResponse() {
    }

    public BalanceAnualSocioResponse(
            Integer annio,
            BigDecimal ingresos,
            BigDecimal gastos,
            BigDecimal balanceAnual) {
        this.annio = annio;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balanceAnual = balanceAnual;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
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

    public BigDecimal getBalanceAnual() {
        return balanceAnual;
    }

    public void setBalanceAnual(BigDecimal balanceAnual) {
        this.balanceAnual = balanceAnual;
    }

}
