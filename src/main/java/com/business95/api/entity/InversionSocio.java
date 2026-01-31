package com.business95.api.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "inversiones_socios", uniqueConstraints = {
        @UniqueConstraint(name = "uk_inversion_socio", columnNames = { "id_inversion", "id_socio" })
})
public class InversionSocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inversion_socio")
    private Long idInversionSocio;

    @ManyToOne
    @JoinColumn(name = "id_socio", nullable = false)
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(name = "fecha_registro", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "fecha_modificacion", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_socio_creacion", nullable = false)
    private Socio socioCreacion;

    @ManyToOne
    @JoinColumn(name = "id_socio_modificacion", nullable = false)
    private Socio socioModificacion;

    public InversionSocio() {
    }

    public InversionSocio(Long idInversionSocio,
            Socio socio,
            Rol rol,
            LocalDateTime fechaRegistro,
            LocalDateTime fechaModificacion,
            Socio socioCreacion,
            Socio socioModificacion) {
        this.idInversionSocio = idInversionSocio;
        this.socio = socio;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.socioCreacion = socioCreacion;
        this.socioModificacion = socioModificacion;
    }

    public Long getIdInversionSocio() {
        return idInversionSocio;
    }

    public void setIdInversionSocio(Long idInversionSocio) {
        this.idInversionSocio = idInversionSocio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Socio getSocioCreacion() {
        return socioCreacion;
    }

    public void setSocioCreacion(Socio socioCreacion) {
        this.socioCreacion = socioCreacion;
    }

    public Socio getSocioModificacion() {
        return socioModificacion;
    }

    public void setSocioModificacion(Socio socioModificacion) {
        this.socioModificacion = socioModificacion;
    }

}
