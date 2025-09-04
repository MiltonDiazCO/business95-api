package com.business95.api.business95_api.projections;

import java.math.BigDecimal;

public interface BalanceSocioProjection {
    String getSocio();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalanceSocio();
}
