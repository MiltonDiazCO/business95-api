package com.business95.api.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "inversiones")
public class Inversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inversion", nullable = false)
    private Long idInversion;

    @NotBlank(message = "El nombre de la inversión es es requerido.")
    @Column(name = "inversion", nullable = false, length = 80)
    private String inversion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "inversiones_socios",
        joinColumns = @JoinColumn(name = "id_inversion", referencedColumnName = "id_inversion"),
        inverseJoinColumns = @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    )
    private List<Socio> socios = new ArrayList<>();

    public Inversion() {
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

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public void addSocio(Socio socio) {
        this.socios.add(socio);
    }

    public void removeSocio(Socio socio) {
        this.socios.remove(socio);
    }

}
