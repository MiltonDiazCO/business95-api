package com.business95.api.business95_api.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovConBalancesSociosRes extends BalanceMovsPorInvRes {

    private List<BalanceSocioPorMovRes> balances = new ArrayList<>();

    public MovConBalancesSociosRes() {
    }

    public MovConBalancesSociosRes(List<BalanceSocioPorMovRes> balances) {
        this.balances = balances;
    }

    public MovConBalancesSociosRes(
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

    public List<BalanceSocioPorMovRes> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceSocioPorMovRes> balances) {
        this.balances = balances;
    }

    public void addBalanceSocio(BalanceSocioPorMovRes balanceSocioResponse) {
        this.balances.add(balanceSocioResponse);
    }

}
