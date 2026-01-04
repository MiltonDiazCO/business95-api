package com.business95.api.dtos.responses;

import java.util.Set;

public class UsuarioResponse {

    private Long idUsuario;

    private String usuario;

    private String contrasena;

    private Boolean habilitado;

    private Set<String> roles;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long idUsuario,
            String usuario,
            String contrasena,
            Boolean habilitado,
            Set<String> roles) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.habilitado = habilitado;
        this.roles = roles;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
