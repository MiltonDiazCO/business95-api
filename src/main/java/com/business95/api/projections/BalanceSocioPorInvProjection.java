package com.business95.api.projections;

import java.math.BigDecimal;

public interface BalanceSocioPorInvProjection {

    String getSocio();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalanceSocio();

}
