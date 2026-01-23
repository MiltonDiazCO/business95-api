package com.business95.api.dto.response;

import java.math.BigDecimal;

public class BalanceSocioPorInversionResponse {

    private Long idSocio;
    private String socio;
    private BigDecimal ingresos;
    private BigDecimal gastos;
    private BigDecimal balance;

    public BalanceSocioPorInversionResponse() {
    }

    public BalanceSocioPorInversionResponse(
            Long idSocio,
            String socio,
            BigDecimal ingresos,
            BigDecimal gastos,
            BigDecimal balance) {
        this.idSocio = idSocio;
        this.socio = socio;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balance = balance;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
