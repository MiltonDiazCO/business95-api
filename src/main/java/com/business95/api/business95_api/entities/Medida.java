package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medidas")
public class Medida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medida")
    private Long idMedida;

    @Column(name = "medida", nullable = false, unique = true, length = 20)
    private String medida;

    @Column(name = "descripcion", nullable = false, length = 60)
    private String descripcion;

    public Medida() {
    }

    public Medida(Long idMedida, String medida, String descripcion) {
        this.idMedida = idMedida;
        this.medida = medida;
        this.descripcion = descripcion;
    }

    public Long getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Long idMedida) {
        this.idMedida = idMedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
