package com.business95.api.business95_api.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MovimientoUpdateRequestDTO {

    private Long movimiento;

    @NotNull(message = "La Inversión es requerida.")
    private Long inversion;

    @NotBlank(message = "El Concepto del movimiento es requerido.")
    @Size(max = 120, message = "El concepto debe ser de máximo 120 caracteres.")
    private String concepto;

    @NotNull(message = "La Categoría es requerida.")
    private Long categoria;

    @Pattern(regexp = "^[A-Z]{3}$", message = "El código de la moneda debe tener exactamente 3 letras mayúsculas.")
    private String moneda;
    private Long medida;

    public MovimientoUpdateRequestDTO() {
    }

    public MovimientoUpdateRequestDTO(Long movimiento, @NotNull(message = "La Inversión es requerida.") Long inversion,
            @NotBlank(message = "El Concepto del movimiento es requerido.") @Size(max = 120, message = "El concepto debe ser de máximo 120 caracteres.") String concepto,
            @NotNull(message = "La Categoría es requerida.") Long categoria,
            @Pattern(regexp = "^[A-Z]{3}$", message = "El código de la moneda debe tener exactamente 3 letras mayúsculas.") String moneda,
            Long medida) {
        this.movimiento = movimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.moneda = moneda;
        this.medida = medida;
    }

    public Long getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Long movimiento) {
        this.movimiento = movimiento;
    }

    public Long getInversion() {
        return inversion;
    }

    public void setInversion(Long inversion) {
        this.inversion = inversion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Long getMedida() {
        return medida;
    }

    public void setMedida(Long medida) {
        this.medida = medida;
    }

}
