package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimientoDTO;

public class BalanceSocioPorMovimientoResponseDTO extends DetalleMovimientoDTO {

    private List<BalanceSocioResponseDTO> balances = new ArrayList<>();

    public BalanceSocioPorMovimientoResponseDTO() {
    }

    public BalanceSocioPorMovimientoResponseDTO(List<BalanceSocioResponseDTO> balances) {
        this.balances = balances;
    }

    public BalanceSocioPorMovimientoResponseDTO(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            List<BalanceSocioResponseDTO> balances) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.balances = balances;
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
