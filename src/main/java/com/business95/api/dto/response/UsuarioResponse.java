package com.business95.api.dto.response;

import java.util.Set;

public class UsuarioResponse {

    private Long idUsuario;
    private Boolean habilitado;
    private Set<String> roles;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long idUsuario, Boolean habilitado, Set<String> roles) {
        this.idUsuario = idUsuario;
        this.habilitado = habilitado;
        this.roles = roles;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
