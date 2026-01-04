package com.business95.api.dtos.responses;

import java.util.List;

public class InversionConSociosResponse {

    private Long idInversion;
    private String inversion;
    private List<SocioResponse> socios;

    public InversionConSociosResponse() {
    }

    public InversionConSociosResponse(Long idInversion, String inversion, List<SocioResponse> socios) {
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

    public List<SocioResponse> getSocios() {
        return socios;
    }

    public void setSocios(List<SocioResponse> socios) {
        this.socios = socios;
    }

    public void addSocio(SocioResponse socioResponse) {
        this.socios.add(socioResponse);
    }

}
