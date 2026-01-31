package com.business95.api.dto.request;

public class SocioRolInversionRequest {

    private Long idSocio;
    private String Rol;

    public SocioRolInversionRequest() {
    }

    public SocioRolInversionRequest(Long idSocio, String rol) {
        this.idSocio = idSocio;
        Rol = rol;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

}
