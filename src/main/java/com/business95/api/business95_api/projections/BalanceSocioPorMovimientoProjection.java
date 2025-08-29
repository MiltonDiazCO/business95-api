package com.business95.api.business95_api.projections;

import java.math.BigDecimal;

public interface BalanceSocioPorMovimientoProjection {
    Long getIdMovimiento();

    String getInversion();

    String getConcepto();

    String getCategoria();

    String getMedida();

    String getMoneda();

    String getSocio();

    BigDecimal getCantidad();

    BigDecimal getBalanceMonetario();
}
