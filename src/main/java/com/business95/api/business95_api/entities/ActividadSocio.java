package com.business95.api.business95_api.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "actividades_socios")
public class ActividadSocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long idActividad;

    @ManyToOne
    @JoinColumn(name = "id_socio", nullable = false)
    private Socio socio;

    // @ManyToOne
    // @JoinColumn(name = "id_movimiento", nullable = false)
    // private Movimiento movimiento;

    @Column(name = "monto", precision = 10, scale = 2, nullable = false)
    @ColumnDefault("0.00")
    private BigDecimal monto;

    @Column(name = "cantidad", precision = 10, scale = 2, nullable = false)
    @ColumnDefault("0.00")
    private BigDecimal cantidad;

    @Column(name = "fecha", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_tipo_actividad", nullable = false)
    private TipoActividad tipoActividad;

    @PrePersist
    public void prePersist() {
        if (monto == null) {
            monto = BigDecimal.valueOf(0.00);
        }

        if (cantidad == null) {
            cantidad = BigDecimal.valueOf(0.00);
        }

        if (fecha == null) {
            fecha = LocalDateTime.now();
        }
    }

    public ActividadSocio() {
    }

    public ActividadSocio(Long idActividad, Socio socio, BigDecimal monto, BigDecimal cantidad,
            LocalDateTime fecha, TipoActividad tipoActividad) {
        this.idActividad = idActividad;
        this.socio = socio;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
