package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

public class BalanceSociosPorMovimientoResponseDTO {

    private Long idMovimiento;
    private String inversion;
    private String concepto;
    private String categoria;
    private String medida;
    private String moneda;
    private List<BalanceSocioResponseDTO> balances = new ArrayList<>();

    public BalanceSociosPorMovimientoResponseDTO() {
    }

    public BalanceSociosPorMovimientoResponseDTO(Long idMovimiento, String inversion, String concepto, String categoria,
            String medida, String moneda, List<BalanceSocioResponseDTO> balances) {
        this.idMovimiento = idMovimiento;
        this.inversion = inversion;
        this.concepto = concepto;
        this.categoria = categoria;
        this.medida = medida;
        this.moneda = moneda;
        this.balances = balances;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public List<BalanceSocioResponseDTO> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceSocioResponseDTO> balances) {
        this.balances = balances;
    }

    public void addBalanceSocio(BalanceSocioResponseDTO balanceSocioResponseDTO) {
        this.balances.add(balanceSocioResponseDTO);
    }

}
