package com.business95.api.projection;

import java.math.BigDecimal;

public interface BalanceInversionProjection {

    Long getIdInversion();

    String getInversion();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalance();

}
