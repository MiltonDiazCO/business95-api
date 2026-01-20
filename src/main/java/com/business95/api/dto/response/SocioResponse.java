package com.business95.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocioResponse {

    private Long idSocio;
    private String socio;
    private String correoElectronico;
    private String telefono;
    private String tipoPersona;
    private UsuarioResponse detalleUsuario;

    public SocioResponse() {
    }

    public SocioResponse(
            Long idSocio,
            String socio,
            String correoElectronico,
            String telefono,
            String tipoPersona,
            UsuarioResponse detalleUsuario) {
        this.idSocio = idSocio;
        this.socio = socio;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
        this.detalleUsuario = detalleUsuario;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public UsuarioResponse getDetalleUsuario() {
        return detalleUsuario;
    }

    public void setDetalleUsuario(UsuarioResponse detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }

}
