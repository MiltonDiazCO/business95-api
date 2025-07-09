package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inversiones")
public class Inversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inversion", nullable = false)
    private Long id_inversion;

    @Column(name = "inversion", nullable = false, length = 80)
    private String inversion;

    public Inversion() {
    }

    public Inversion(Long id_inversion, String inversion) {
        this.id_inversion = id_inversion;
        this.inversion = inversion;
    }

    public Long getId_inversion() {
        return id_inversion;
    }

    public void setId_inversion(Long id_inversion) {
        this.id_inversion = id_inversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

}
