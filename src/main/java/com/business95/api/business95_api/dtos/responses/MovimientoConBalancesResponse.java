package com.business95.api.business95_api.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.business95.api.business95_api.dtos.bases.DetalleMovimiento;

public class MovimientoConBalancesResponse extends DetalleMovimiento {

    private List<BalanceSocioResponse> balances = new ArrayList<>();

    public MovimientoConBalancesResponse() {
    }

    public MovimientoConBalancesResponse(List<BalanceSocioResponse> balances) {
        this.balances = balances;
    }

    public MovimientoConBalancesResponse(
            Long idMovimiento,
            String inversion,
            String concepto,
            String categoria,
            String medida,
            String moneda,
            List<BalanceSocioResponse> balances) {
        super(idMovimiento, inversion, concepto, categoria, medida, moneda);
        this.balances = balances;
    }

    public List<BalanceSocioResponse> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceSocioResponse> balances) {
        this.balances = balances;
    }

    public void addBalanceSocio(BalanceSocioResponse balanceSocioResponse) {
        this.balances.add(balanceSocioResponse);
    }

}
