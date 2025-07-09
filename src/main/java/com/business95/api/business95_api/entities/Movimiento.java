package com.business95.api.business95_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_inversion", nullable = false)
    private Inversion inversion;

    @Column(name = "concepto", nullable = false, length = 120)
    private String concepto;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_moneda", nullable = true)
    private Moneda moneda;

    @ManyToOne
    @JoinColumn(name = "id_medida", nullable = true)
    private Medida medida;

    public Movimiento() {
    }

    public Movimiento(Long idMovimiento, Inversion inversion, String concepto, Categoria categoria, Moneda moneda,
            Medida medida) {
        this.idMovimiento = idMovimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.moneda = moneda;
        this.medida = medida;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Inversion getInversion() {
        return inversion;
    }

    public void setInversion(Inversion inversion) {
        this.inversion = inversion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

}
