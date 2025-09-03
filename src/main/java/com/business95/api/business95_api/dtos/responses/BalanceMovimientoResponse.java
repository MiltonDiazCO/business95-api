package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idMovimiento", "inversion", "concepto", "categoria",
        "cantidadMovimiento", "medida", "balanceMovimiento", "moneda", "fechaUltimaActividad" })
public class BalanceMovimientoResponse extends DetalleMovimiento {

    private BigDecimal cantidadMovimiento;
    private BigDecimal balanceMovimiento;
    private LocalDateTime fechaUltimaActividad;

    public BalanceMovimientoResponse() {
    }

    public BalanceMovimientoResponse(
            BigDecimal cantidadMovimiento,
            BigDecimal balanceMovimiento,
            LocalDateTime fechaUltimaActividad) {
        this.cantidadMovimiento = cantidadMovimiento;
        this.balanceMovimiento = balanceMovimiento;
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    public BalanceMovimientoResponse(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            BigDecimal cantidadMovimiento,
            BigDecimal balanceMovimiento,
            LocalDateTime fechaUltimaActividad) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.cantidadMovimiento = cantidadMovimiento;
        this.balanceMovimiento = balanceMovimiento;
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    public BigDecimal getCantidadMovimiento() {
        return cantidadMovimiento;
    }

    public void setCantidadMovimiento(BigDecimal cantidadMovimiento) {
        this.cantidadMovimiento = cantidadMovimiento;
    }

    public BigDecimal getBalanceMovimiento() {
        return balanceMovimiento;
    }

    public void setBalanceMovimiento(BigDecimal balanceMovimiento) {
        this.balanceMovimiento = balanceMovimiento;
    }

    public LocalDateTime getFechaUltimaActividad() {
        return fechaUltimaActividad;
    }

    public void setFechaUltimaActividad(LocalDateTime fechaUltimaActividad) {
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

}
