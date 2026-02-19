package com.business95.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActividadRecienteResponse {

    private Long idActividad;
    private Long idSocio;
    private String socio;
    private BigDecimal cantidad;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String tipoActividad;
    private Long idMovimiento;
    private String movimiento;
    private Long idInversion;
    private String inversion;

    public ActividadRecienteResponse() {
    }

    public ActividadRecienteResponse(
            Long idActividad,
            Long idSocio,
            String socio,
            BigDecimal cantidad,
            BigDecimal monto,
            LocalDateTime fecha,
            String tipoActividad,
            Long idMovimiento,
            String movimiento,
            Long idInversion,
            String inversion) {
        this.idActividad = idActividad;
        this.idSocio = idSocio;
        this.socio = socio;
        this.cantidad = cantidad;
        this.monto = monto;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
        this.idMovimiento = idMovimiento;
        this.movimiento = movimiento;
        this.idInversion = idInversion;
        this.inversion = inversion;
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

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Long getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(Long idInversion) {
        this.idInversion = idInversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

}
