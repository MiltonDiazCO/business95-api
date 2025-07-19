package com.business95.api.business95_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class ActividadDTO {

    @NotNull(message = "Hay actividades sin un socio asociado. El socio es requerido para cada actividad a registrar.")
    private Long socio;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal monto;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal cantidad;

    @NotNull(message = "Hay actividades sin una fecha asociada. La fecha es requerida para cada actividad a registrar.")
    private LocalDateTime fecha;
    private Long tipoActividad;

    public ActividadDTO() {
    }

    public ActividadDTO(Long socio, BigDecimal monto, BigDecimal cantidad, LocalDateTime fecha,
            Long tipoActividad) {
        this.socio = socio;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
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
