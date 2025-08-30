package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceMovimientoResponse extends DetalleMovimiento {

    private BigDecimal cantidad;
    private BigDecimal balance;
    private LocalDateTime fechaUltimaActividad;

    public BalanceMovimientoResponse() {
    }

    public BalanceMovimientoResponse(
            BigDecimal cantidad,
            BigDecimal balance,
            LocalDateTime fechaUltimaActividad) {
        this.cantidad = cantidad;
        this.balance = balance;
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    public BalanceMovimientoResponse(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            BigDecimal cantidad,
            BigDecimal balance,
            LocalDateTime fechaUltimaActividad) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.cantidad = cantidad;
        this.balance = balance;
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getFechaUltimaActividad() {
        return fechaUltimaActividad;
    }

    public void setFechaUltimaActividad(LocalDateTime fechaUltimaActividad) {
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

}
