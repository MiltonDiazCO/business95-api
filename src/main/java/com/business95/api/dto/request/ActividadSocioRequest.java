package com.business95.api.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActividadSocioRequest {

    private Long idActividad;

    @NotNull(message = "Hay actividades sin un socio asociado. El socio es requerido para cada actividad a registrar.")
    private Long socio;

    @Digits(integer = 8, fraction = 2, message = "La cantidad debe tener el formato 8.2 (máximo 8 cifras enteras y 2 decimales). Ejemplo: '43.15'")
    private BigDecimal cantidad;

    @Digits(integer = 8, fraction = 2, message = "El monto debe tener el formato 8.2 (máximo 8 cifras enteras y 2 decimales). Ejemplo: '43.15'")
    private BigDecimal monto;

    @NotNull(message = "Hay actividades sin una fecha asociada. La fecha es requerida para cada actividad a registrar.")
    private LocalDateTime fecha;

    @NotNull(message = "Hay actividades sin un tipo de actividad asociado. El tipo de actividad es requerido para cada actividad a registrar.")
    private Long tipoActividad;

    public ActividadSocioRequest() {
    }

    public ActividadSocioRequest(Long idActividad,
            @NotNull(message = "Hay actividades sin un socio asociado. El socio es requerido para cada actividad a registrar.") Long socio,
            @Digits(integer = 8, fraction = 2, message = "La cantidad debe tener el formato 8.2 (máximo 8 cifras enteras y 2 decimales). Ejemplo: '43.15'") BigDecimal cantidad,
            @Digits(integer = 8, fraction = 2, message = "El monto debe tener el formato 8.2 (máximo 8 cifras enteras y 2 decimales). Ejemplo: '43.15'") BigDecimal monto,
            @NotNull(message = "Hay actividades sin una fecha asociada. La fecha es requerida para cada actividad a registrar.") LocalDateTime fecha,
            @NotNull(message = "Hay actividades sin un tipo de actividad asociado. El tipo de actividad es requerido para cada actividad a registrar.") Long tipoActividad) {
        this.idActividad = idActividad;
        this.socio = socio;
        this.cantidad = cantidad;
        this.monto = monto;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getSocio() {
        return socio;
    }

    public void setSocio(Long socio) {
        this.socio = socio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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
