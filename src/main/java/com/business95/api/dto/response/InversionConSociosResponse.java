package com.business95.api.dto.response;

import java.util.List;

public class InversionConSociosResponse {

    private Long idInversion;
    private String inversion;
    private List<SocioNombresResponse> socios;

    public InversionConSociosResponse() {
    }

    public InversionConSociosResponse(Long idInversion, String inversion, List<SocioNombresResponse> socios) {
        this.idInversion = idInversion;
        this.inversion = inversion;
        this.socios = socios;
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

    public List<SocioNombresResponse> getSocios() {
        return socios;
    }

    public void setSocios(List<SocioNombresResponse> socios) {
        this.socios = socios;
    }

    public void addSocio(SocioNombresResponse socioResponse) {
        this.socios.add(socioResponse);
    }

}
