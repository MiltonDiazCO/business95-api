package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovimientoConBalancesResponse extends BalanceMovimientoResponse {

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
            BigDecimal cantidadMovimiento,
            BigDecimal balanceMovimiento,
            LocalDateTime fechaUltimaActividad) {
        super(idMovimiento,
                inversion,
                concepto,
                categoria,
                medida,
                moneda,
                cantidadMovimiento,
                balanceMovimiento,
                fechaUltimaActividad);
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
