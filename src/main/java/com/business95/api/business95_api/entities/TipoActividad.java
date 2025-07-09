package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_actividades")
public class TipoActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_actividad")
    private Long idTipoActividad;

    @Column(name = "tipo_actividad", nullable = false, length = 40)
    private String tipoActividad;

    @Column(name = "descripcion", nullable = false, length = 240)
    private String descripcion;

    @Column(name = "naturaleza", nullable = false)
    @Enumerated(EnumType.STRING)
    private NaturalezaActividad naturaleza;

    public TipoActividad() {
    }

    public TipoActividad(Long idTipoActividad, String tipoActividad, String descripcion,
            NaturalezaActividad naturaleza) {
        this.idTipoActividad = idTipoActividad;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
        this.naturaleza = naturaleza;
    }

    public Long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(Long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NaturalezaActividad getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(NaturalezaActividad naturaleza) {
        this.naturaleza = naturaleza;
    }

}

enum NaturalezaActividad {
    CREDITO,
    DEBITO,
    NO_FINANCIERO
}