package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monedas")
public class Moneda {

    @Id
    @Column(name = "id_moneda", unique = true, length = 3)
    private String idMoneda;

    @Column(name = "moneda", nullable = false, length = 30)
    private String moneda;

    public Moneda() {
    }

    public Moneda(String idMoneda, String moneda) {
        this.idMoneda = idMoneda;
        this.moneda = moneda;
    }

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
