package com.business95.api.dto.response;

import java.time.LocalDateTime;

public class SocioPorInversionResponse {

    private Long idSocio;
    private String socio;
    private String rol;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaModificacion;
    private Long idSocioCreacion;
    private String socioCreacion;
    private Long idSocioModificacion;
    private String socioModificacion;

    public SocioPorInversionResponse() {
    }

    public SocioPorInversionResponse(
            Long idSocio,
            String socio,
            String rol,
            LocalDateTime fechaRegistro,
            LocalDateTime fechaModificacion,
            Long idSocioCreacion,
            String socioCreacion,
            Long idSocioModificacion,
            String socioModificacion) {
        this.idSocio = idSocio;
        this.socio = socio;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.idSocioCreacion = idSocioCreacion;
        this.socioCreacion = socioCreacion;
        this.idSocioModificacion = idSocioModificacion;
        this.socioModificacion = socioModificacion;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdSocioCreacion() {
        return idSocioCreacion;
    }

    public void setIdSocioCreacion(Long idSocioCreacion) {
        this.idSocioCreacion = idSocioCreacion;
    }

    public String getSocioCreacion() {
        return socioCreacion;
    }

    public void setSocioCreacion(String socioCreacion) {
        this.socioCreacion = socioCreacion;
    }

    public Long getIdSocioModificacion() {
        return idSocioModificacion;
    }

    public void setIdSocioModificacion(Long idSocioModificacion) {
        this.idSocioModificacion = idSocioModificacion;
    }

    public String getSocioModificacion() {
        return socioModificacion;
    }

    public void setSocioModificacion(String socioModificacion) {
        this.socioModificacion = socioModificacion;
    }

}
