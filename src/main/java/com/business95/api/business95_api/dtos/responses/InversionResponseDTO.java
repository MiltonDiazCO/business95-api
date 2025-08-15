package com.business95.api.business95_api.dtos.responses;

public class InversionResponseDTO {

    private Long idInversion;
    private String inversion;

    public InversionResponseDTO() {
    }

    public InversionResponseDTO(Long idInversion, String inversion) {
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
