package com.business95.api.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocioResponse {

    private Long idSocio;
    private String socio;
    private String telefono;
    private String tipoPersona;
    private UsuarioResponse usuario;

    public SocioResponse() {
    }

    public SocioResponse(Long idSocio,
            String socio,
            String telefono,
            String tipoPersona,
            UsuarioResponse usuario) {
        this.idSocio = idSocio;
        this.socio = socio;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
        this.usuario = usuario;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public UsuarioResponse getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponse usuario) {
        this.usuario = usuario;
    }

}
