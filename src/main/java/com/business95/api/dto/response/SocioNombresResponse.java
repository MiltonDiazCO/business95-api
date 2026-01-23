package com.business95.api.dto.response;

public class SocioNombresResponse {

    private Long idSocio;
    private String socio;

    public SocioNombresResponse() {
    }

    public SocioNombresResponse(Long idSocio, String socio) {
        this.idSocio = idSocio;
        this.socio = socio;
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

}
