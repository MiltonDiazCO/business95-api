package com.business95.api.business95_api.projections;

import java.math.BigDecimal;

public interface BalanceAnualSocioProjection {

    Integer getAnnio();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalanceAnual();
}
