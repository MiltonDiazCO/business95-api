package com.business95.api.entity;

import com.business95.api.enums.ModuloRol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "rol", nullable = false, unique = true, length = 45)
    private String rol;

    @Column(name = "modulo", nullable = false)
    @Enumerated(EnumType.STRING)
    private ModuloRol modulo;

    public Rol() {
    }

    public Rol(Long idRol, String rol, ModuloRol modulo) {
        this.idRol = idRol;
        this.rol = rol;
        this.modulo = modulo;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ModuloRol getModulo() {
        return modulo;
    }

    public void setModulo(ModuloRol modulo) {
        this.modulo = modulo;
    }

}
