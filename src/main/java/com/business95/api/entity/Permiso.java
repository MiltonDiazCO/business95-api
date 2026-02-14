package com.business95.api.entity;

import java.util.HashSet;
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
@Table(name = "permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Long idPermiso;

    @Column(name = "permiso", nullable = false, length = 45)
    private String permiso;

    @ManyToMany
    @JoinTable(name = "roles_permisos", joinColumns = @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public Permiso() {
    }

    public Permiso(Long idPermiso, String permiso, Set<Rol> roles) {
        this.idPermiso = idPermiso;
        this.permiso = permiso;
        this.roles = roles;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
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
