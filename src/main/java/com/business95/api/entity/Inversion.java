package com.business95.api.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inversiones")
public class Inversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inversion", nullable = false)
    private Long idInversion;

    @Column(name = "inversion", nullable = false, length = 80)
    private String inversion;

    @OneToMany(mappedBy = "inversion", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<InversionSocio> socios = new HashSet<>();

    public Inversion() {
    }

    public Inversion(String inversion) {
        this.inversion = inversion;
    }

    public Inversion(Long idInversion, String inversion) {
        this.idInversion = idInversion;
        this.inversion = inversion;
    }

    public Long getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(Long idInversion) {
        this.idInversion = idInversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public Set<InversionSocio> getSocios() {
        return socios;
    }

    public void setSocios(Set<InversionSocio> socios) {
        this.socios = socios;
    }

    public void addSocio(InversionSocio socio) {
        this.socios.add(socio);
        socio.setInversion(this);
    }

    public void removeSocio(InversionSocio socio) {
        this.socios.remove(socio);
    }

}
