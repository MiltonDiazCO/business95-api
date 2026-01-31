package com.business95.api.dto.response;

import java.util.Set;

public class InversionConSociosResponse {

    private Long idInversion;
    private String inversion;
    private Set<SocioRolInversionResponse> socios;

    public InversionConSociosResponse() {
    }

    public InversionConSociosResponse(Long idInversion, String inversion, Set<SocioRolInversionResponse> socios) {
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

    public Set<SocioRolInversionResponse> getSocios() {
        return socios;
    }

    public void setSocios(Set<SocioRolInversionResponse> socios) {
        this.socios = socios;
    }

    public void addSocio(SocioRolInversionResponse socioResponse) {
        this.socios.add(socioResponse);
    }

}
