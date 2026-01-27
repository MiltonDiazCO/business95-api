package com.business95.api.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class InversionRequest {

    @NotBlank(message = "El nombre de la inversión es requerida.")
    @Size(max = 80, message = "El nombre de la inversión debe ser de máximo 80 caracteres.")
    private String inversion;

    @Valid
    @NotEmpty(message = "Debe asociar por lo menos un socio a la nueva inversión")
    private List<Long> socios;

    public InversionRequest() {
    }

    public InversionRequest(
            @NotBlank(message = "El nombre de la inversión es requerida.") @Size(max = 80, message = "El nombre de la inversión debe ser de máximo 80 caracteres.") String inversion,
            @Valid @NotEmpty(message = "Debe asociar por lo menos un socio a la nueva inversión") List<Long> socios) {
        this.inversion = inversion;
        this.socios = socios;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public List<Long> getSocios() {
        return socios;
    }

    public void setSocios(List<Long> socios) {
        this.socios = socios;
    }

}
