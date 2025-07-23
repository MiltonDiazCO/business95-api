package com.business95.api.business95_api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActividadResponseDTO {

    private Long idActividad;
    private String socio;
    private BigDecimal monto;
    private BigDecimal cantidad;
    private LocalDateTime fecha;
    private String tipoActividad;

    public ActividadResponseDTO() {
    }

    public ActividadResponseDTO(Long idActividad, String socio, BigDecimal monto, BigDecimal cantidad,
            LocalDateTime fecha, String tipoActividad) {
        this.idActividad = idActividad;
        this.socio = socio;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
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

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
