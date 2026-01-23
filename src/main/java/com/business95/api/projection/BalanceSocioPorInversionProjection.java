package com.business95.api.projection;

import java.math.BigDecimal;

public interface BalanceSocioPorInversionProjection {

    Long getIdSocio();
    
    String getSocio();

    BigDecimal getIngresos();

    BigDecimal getGastos();

    BigDecimal getBalance();

}
