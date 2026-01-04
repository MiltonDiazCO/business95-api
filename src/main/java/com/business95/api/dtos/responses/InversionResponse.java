package com.business95.api.dtos.responses;

public class InversionResponse {

    private Long idInversion;
    private String inversion;

    public InversionResponse() {
    }

    public InversionResponse(Long idInversion, String inversion) {
        this.idInversion = idInversion;
        this.inversion = inversion;
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
