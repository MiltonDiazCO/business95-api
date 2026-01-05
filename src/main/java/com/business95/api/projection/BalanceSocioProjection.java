package com.business95.api.projection;

import java.math.BigDecimal;

public interface BalanceSocioProjection {
    String getSocio();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalance();
}
