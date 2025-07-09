package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long idSocio;

    @Column(name = "nombres_razonsocial", nullable = false, length = 120)
    private String nombresRazonsocial;

    @Column(name = "apellidos", nullable = true, length = 60)
    private String apellidos;

    @Column(name = "telefono", nullable = false, length = 30)
    private String telefono;

    @Column(name = "correo_electronico", nullable = true, length = 120)
    private String correoElectronico;

    @ManyToOne
    @JoinColumn(name = "id_tipo_persona", nullable = false)
    private TipoPersona tipoPersona;

    public Socio() {
    }

    public Socio(Long idSocio, String nombresRazonsocial, String apellidos, String telefono, String correoElectronico,
            TipoPersona tipoPersona) {
        this.idSocio = idSocio;
        this.nombresRazonsocial = nombresRazonsocial;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipoPersona = tipoPersona;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

}
