package com.business95.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ActualizarContrasenaPorCorreoRequest {

    @NotNull(message = "El correo electrónico es requerido.")
    @Size(max = 150, message = "El correo electrónico debe ser máximo de 150 caracteres.")
    private String correoEletronico;

    @NotNull(message = "La contraseña es requerida.")
    @Size(min = 4, message = "La contraseña debe contener al menos 4 caracteres.")
    private String contrasena;

    public ActualizarContrasenaPorCorreoRequest() {
    }

    public ActualizarContrasenaPorCorreoRequest(
            @NotNull(message = "El correo electrónico es requerido.") @Size(max = 150, message = "El correo electrónico debe ser máximo de 150 caracteres.") String correoEletronico,
            @NotNull(message = "La contraseña es requerida.") @Size(min = 4, message = "La contraseña debe contener al menos 4 caracteres.") String contrasena) {
        this.correoEletronico = correoEletronico;
        this.contrasena = contrasena;
    }

    public String getCorreoEletronico() {
        return correoEletronico;
    }

    public void setCorreoEletronico(String correoEletronico) {
        this.correoEletronico = correoEletronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
