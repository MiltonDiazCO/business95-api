package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActividadSocioResponseDTO {

    private Long idActividad;
    private String socio;
    private BigDecimal cantidad;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String tipoActividad;

    public ActividadSocioResponseDTO() {
    }

    public ActividadSocioResponseDTO(Long idActividad, String socio, BigDecimal cantidad, BigDecimal monto,
            LocalDateTime fecha, String tipoActividad) {
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

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
