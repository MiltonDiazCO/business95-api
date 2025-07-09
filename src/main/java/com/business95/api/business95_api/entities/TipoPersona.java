package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_personas")
public class TipoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_persona")
    private Long idTipoPersona;

    @Column(name = "tipo_persona", nullable = false, length = 60)
    private String tipoPersona;

    public TipoPersona() {
    }

    public TipoPersona(Long idTipoPersona, String tipoPersona) {
        this.idTipoPersona = idTipoPersona; 
        this.tipoPersona = tipoPersona;
    }

    public Long getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Long idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

}
