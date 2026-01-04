package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceSocioResponse {

    private String socio;
    private BigDecimal ingresos;
    private BigDecimal gastos;
    private BigDecimal balance;
    private List<BalanceAnualSocioResponse> historialAnual = new ArrayList<>();

    public BalanceSocioResponse() {
    }

    public BalanceSocioResponse(String socio, BigDecimal ingresos, BigDecimal gastos, BigDecimal balance) {
        this.socio = socio;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balance = balance;
    }

    public BalanceSocioResponse(String socio, BigDecimal ingresos, BigDecimal gastos, BigDecimal balance,
            List<BalanceAnualSocioResponse> historialAnual) {
        this.socio = socio;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balance = balance;
        this.historialAnual = historialAnual;
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

    public List<BalanceAnualSocioResponse> getHistorialAnual() {
        return historialAnual;
    }

    public void setHistorialAnual(List<BalanceAnualSocioResponse> historialAnual) {
        this.historialAnual = historialAnual;
    }

    public void addhistorialAnual(BalanceAnualSocioResponse balanceAnualSocio) {
        this.historialAnual.add(balanceAnualSocio);
    }

}
