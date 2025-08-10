package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;

public class BalanceSocioResponseDTO {

    private String socio;
    private BigDecimal cantidad;
    private BigDecimal balanceMonetario;

    public BalanceSocioResponseDTO() {
    }

    public BalanceSocioResponseDTO(String socio, BigDecimal cantidad, BigDecimal balanceMonetario) {
        this.socio = socio;
        this.cantidad = cantidad;
        this.balanceMonetario = balanceMonetario;
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
