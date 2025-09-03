package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;

public class BalanceSocioResponse extends DetalleMovimiento {

    private String socio;
    private BigDecimal cantidadSocio;
    private BigDecimal balanceSocio;

    public BalanceSocioResponse() {
    }

    public BalanceSocioResponse(String socio, BigDecimal cantidadSocio, BigDecimal balanceSocio) {
        this.socio = socio;
        this.cantidadSocio = cantidadSocio;
        this.balanceSocio = balanceSocio;
    }

    public BalanceSocioResponse(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            String socio,
            BigDecimal cantidadSocio,
            BigDecimal balanceSocio) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.socio = socio;
        this.cantidadSocio = cantidadSocio;
        this.balanceSocio = balanceSocio;
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
