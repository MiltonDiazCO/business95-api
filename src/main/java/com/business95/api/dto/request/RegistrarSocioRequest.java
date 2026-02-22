package com.business95.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrarSocioRequest {

    @NotNull(message = "Los nombres o la razón social son obligatorios.")
    @Size(max = 120, message = "Los nombres o la razón social deben ser máximo de 120 caracteres.")
    private String nombresRazonsocial;

    @Size(max = 60, message = "Los apellidos deben ser máximo 60 caracteres.")
    private String apellidos;

    @NotNull(message = "El teléfono es requerido.")
    @Size(max = 30, message = "El teléfono debe ser máximo de 30 caracteres.")
    private String telefono;

    @NotNull(message = "El tipo de persona es requerido.")
    private Long tipoPersona;

    @NotNull(message = "El correo electrónico es requerido.")
    @Size(max = 150, message = "El correo electrónico debe ser máximo de 150 caracteres.")
    private String correoElectronico;

    @NotNull(message = "La contraseña es requerido.")
    @Size(min = 4, message = "La contraseña debe contener al menos 4 caracteres.")
    private String contrasena;

    public RegistrarSocioRequest() {
    }

    public RegistrarSocioRequest(
            @NotNull(message = "Los nombres o la razón social son obligatorios.") @Size(max = 120, message = "Los nombres o la razón social deben ser máximo de 120 caracteres.") String nombresRazonsocial,
            @Size(max = 60, message = "Los apellidos deben ser máximo 60 caracteres.") String apellidos,
            @NotNull(message = "El teléfono es requerido.") @Size(max = 30, message = "El teléfono debe ser máximo de 30 caracteres.") String telefono,
            @NotNull(message = "El tipo de persona es requerido.") Long tipoPersona,
            @NotNull(message = "El correo electrónico es requerido.") @Size(max = 150, message = "El correo electrónico debe ser máximo de 150 caracteres.") String correoElectronico,
            @NotNull(message = "La contraseña es requerido.") @Size(min = 4, message = "La contraseña debe contener al menos 4 caracteres.") String contrasena) {
        this.nombresRazonsocial = nombresRazonsocial;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getNombresRazonsocial() {
        return nombresRazonsocial;
    }

    public void setNombresRazonsocial(String nombresRazonsocial) {
        this.nombresRazonsocial = nombresRazonsocial;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Long tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
