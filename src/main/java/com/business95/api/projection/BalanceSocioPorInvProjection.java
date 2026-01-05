package com.business95.api.projection;

import java.math.BigDecimal;

public interface BalanceSocioPorInvProjection {

    String getSocio();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalanceSocio();

}
