package com.business95.api.dto.request;

public class SocioRolInversionRequest {

    private Long idSocio;
    private String rol;

    public SocioRolInversionRequest() {
    }

    public SocioRolInversionRequest(Long idSocio, String rol) {
        this.idSocio = idSocio;
        this.rol = rol;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
