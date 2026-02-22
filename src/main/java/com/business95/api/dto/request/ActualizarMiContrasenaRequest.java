package com.business95.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ActualizarMiContrasenaRequest {

    @NotNull(message = "La contraseña es requerida.")
    @Size(min = 4, message = "La contraseña debe contener al menos 4 caracteres.")
    private String contrasena;

    public ActualizarMiContrasenaRequest() {
    }

    public ActualizarMiContrasenaRequest(
            @NotNull(message = "La contraseña es requerida.") @Size(min = 4, message = "La contraseña debe contener al menos 4 caracteres.") String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
