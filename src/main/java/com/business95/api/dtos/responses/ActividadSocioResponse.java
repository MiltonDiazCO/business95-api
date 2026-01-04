package com.business95.api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActividadSocioResponse {

    private Long idActividad;
    private Long idSocio;
    private String socio;
    private BigDecimal cantidad;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private Long idTipoActividad;
    private String tipoActividad;

    public ActividadSocioResponse() {
    }

    public ActividadSocioResponse(
            Long idActividad,
            Long idSocio,
            String socio,
            BigDecimal cantidad,
            BigDecimal monto,
            LocalDateTime fecha,
            Long idTipoActividad,
            String tipoActividad) {
        this.idActividad = idActividad;
        this.idSocio = idSocio;
        this.socio = socio;
        this.cantidad = cantidad;
        this.monto = monto;
        this.fecha = fecha;
        this.idTipoActividad = idTipoActividad;
        this.tipoActividad = tipoActividad;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
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

    public Long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(Long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
