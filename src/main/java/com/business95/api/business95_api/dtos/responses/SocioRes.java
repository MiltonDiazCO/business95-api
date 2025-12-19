package com.business95.api.business95_api.dtos.responses;

import com.business95.api.business95_api.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocioRes {

    private Long idSocio;
    private String socio;
    private String telefono;
    private String correoElectronico;
    private String tipoPersona;
    private Usuario usuario;

    public SocioRes() {
    }

    public SocioRes(Long idSocio,
            String socio,
            String telefono,
            String correoElectronico,
            String tipoPersona,
            Usuario usuario) {
        this.idSocio = idSocio;
        this.socio = socio;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
