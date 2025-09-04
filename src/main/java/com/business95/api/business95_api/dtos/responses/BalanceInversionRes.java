package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceInversionRes {

    private String inversion;
    private BigDecimal ingresos;
    private BigDecimal gastos;
    private BigDecimal balanceInversion;
    private List<BalanceSocioPorInvRes> balances = new ArrayList<>();

    public BalanceInversionRes() {
    }

    public BalanceInversionRes(String inversion, BigDecimal ingresos, BigDecimal gastos, BigDecimal balanceInversion) {
        this.inversion = inversion;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balanceInversion = balanceInversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
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

    public BigDecimal getBalanceInversion() {
        return balanceInversion;
    }

    public void setBalanceInversion(BigDecimal balanceInversion) {
        this.balanceInversion = balanceInversion;
    }

    public List<BalanceSocioPorInvRes> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceSocioPorInvRes> balances) {
        this.balances = balances;
    }

    public void addBalanceInvSocio(BalanceSocioPorInvRes balanceInvSocio) {
        this.balances.add(balanceInvSocio);
    }

}
