package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoPorInversionResponseDTO {

    private Long idMovimiento;
    private String categoria;
    private String concepto;
    private BigDecimal cantidad;
    private String medida;
    private BigDecimal balance;
    private String moneda;
    private LocalDateTime fechaUltimaActividad;

    public MovimientoPorInversionResponseDTO() {
    }

    public MovimientoPorInversionResponseDTO(Long idMovimiento, String categoria, String concepto, BigDecimal cantidad,
            String medida, BigDecimal balance, String moneda, LocalDateTime fechaUltimaActividad) {
        this.idMovimiento = idMovimiento;
        this.categoria = categoria;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.medida = medida;
        this.balance = balance;
        this.moneda = moneda;
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public LocalDateTime getFechaUltimaActividad() {
        return fechaUltimaActividad;
    }

    public void setFechaUltimaActividad(LocalDateTime fechaUltimaActividad) {
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

}
