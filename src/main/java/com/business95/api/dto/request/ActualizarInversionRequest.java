package com.business95.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ActualizarInversionRequest {

    @NotBlank(message = "El nombre de la inversión es requerida.")
    @Size(max = 80, message = "El nombre de la inversión debe ser de máximo 80 caracteres.")
    private String inversion;

    public ActualizarInversionRequest() {
    }

    public ActualizarInversionRequest(
            @NotBlank(message = "El nombre de la inversión es requerida.") @Size(max = 80, message = "El nombre de la inversión debe ser de máximo 80 caracteres.") String inversion) {
        this.inversion = inversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

}
