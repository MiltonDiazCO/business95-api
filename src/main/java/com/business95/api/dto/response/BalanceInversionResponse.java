package com.business95.api.dto.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BalanceInversionResponse {

    private Long idInversion;
    private String inversion;
    private BigDecimal ingresos;
    private BigDecimal gastos;
    private BigDecimal balance;
    private List<BalanceSocioResponse> balancesPorSocio = new ArrayList<>();

    public BalanceInversionResponse() {
    }

    public BalanceInversionResponse(Long idInversion, String inversion, BigDecimal ingresos, BigDecimal gastos,
            BigDecimal balance, List<BalanceSocioResponse> balancesPorSocio) {
        this.idInversion = idInversion;
        this.inversion = inversion;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.balance = balance;
        this.balancesPorSocio = balancesPorSocio;
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

    public List<BalanceSocioResponse> getBalancesPorSocio() {
        return balancesPorSocio;
    }

    public void setBalancesPorSocio(List<BalanceSocioResponse> balancesPorSocio) {
        this.balancesPorSocio = balancesPorSocio;
    }

    public void addBalanceSocio(BalanceSocioResponse balanceSocio) {
        this.balancesPorSocio.add(balanceSocio);
    }

}
