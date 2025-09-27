package com.business95.api.business95_api.dtos.responses;

import java.util.List;

public class InversionSociosRes {

    private Long idInversion;
    private String inversion;
    private List<SocioRes> sociosResponse;

    public InversionSociosRes() {
    }

    public InversionSociosRes(Long idInversion, String inversion, List<SocioRes> sociosResponse) {
        this.idInversion = idInversion;
        this.inversion = inversion;
        this.sociosResponse = sociosResponse;
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

    public List<SocioRes> getSociosResponse() {
        return sociosResponse;
    }

    public void setSociosResponse(List<SocioRes> sociosResponse) {
        this.sociosResponse = sociosResponse;
    }

    public void addSocio(SocioRes socioResponse) {
        this.sociosResponse.add(socioResponse);
    }

}
