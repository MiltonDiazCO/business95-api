package com.business95.api.business95_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActividadDTO {

    private Long Movimiento;
    private Long socio;
    private BigDecimal monto;
    private BigDecimal cantidad;
    private LocalDateTime fecha;
    private Long tipoActividad;

    public ActividadDTO() {
    }

    public ActividadDTO(Long movimiento, Long socio, BigDecimal monto, BigDecimal cantidad, LocalDateTime fecha,
            Long tipoActividad) {
        Movimiento = movimiento;
        this.socio = socio;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
    }

    public Long getMovimiento() {
        return Movimiento;
    }

    public void setMovimiento(Long movimiento) {
        Movimiento = movimiento;
    }

    public Long getSocio() {
        return socio;
    }

    public void setSocio(Long socio) {
        this.socio = socio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(Long tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
