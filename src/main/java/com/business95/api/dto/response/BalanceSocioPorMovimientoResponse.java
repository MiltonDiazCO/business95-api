package com.business95.api.dto.response;

import java.math.BigDecimal;

public class BalanceSocioPorMovimientoResponse {

    private Long idSocio;
    private String socio;
    private BigDecimal cantidadSocio;
    private BigDecimal balanceSocio;

    public BalanceSocioPorMovimientoResponse() {
    }

    public BalanceSocioPorMovimientoResponse(
            Long idSocio,
            String socio,
            BigDecimal cantidadSocio,
            BigDecimal balanceSocio) {
        this.idSocio = idSocio;
        this.socio = socio;
        this.cantidadSocio = cantidadSocio;
        this.balanceSocio = balanceSocio;
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
