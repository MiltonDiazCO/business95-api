package com.business95.api.business95_api.projections;

import java.math.BigDecimal;

public interface BalanceInversionProjection {

    String getInversion();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalanceInversion();

}
