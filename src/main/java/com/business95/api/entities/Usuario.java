package com.business95.api.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "correo_electronico", nullable = true, length = 150)
    private String correoElectronico;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado;

    @ManyToMany
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private Set<Rol> roles;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String correoElectronico, String contrasena, Boolean habilitado, Set<Rol> roles) {
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public void addRol(Rol rol) {
        this.roles.add(rol);
    }

    public void removeRol(Rol rol) {
        this.roles.remove(rol);
    }

}
