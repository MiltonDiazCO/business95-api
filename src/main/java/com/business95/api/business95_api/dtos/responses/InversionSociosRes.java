package com.business95.api.business95_api.dtos.responses;

import java.util.List;

public class InversionSociosRes {

    private Long idInversion;
    private String inversion;
    private List<SocioRes> socios;

    public InversionSociosRes() {
    }

    public InversionSociosRes(Long idInversion, String inversion, List<SocioRes> socios) {
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

    public List<SocioRes> getSocios() {
        return socios;
    }

    public void setSocios(List<SocioRes> socios) {
        this.socios = socios;
    }

    public void addSocio(SocioRes socioResponse) {
        this.socios.add(socioResponse);
    }

}
