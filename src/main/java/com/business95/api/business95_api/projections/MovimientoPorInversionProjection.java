package com.business95.api.business95_api.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface MovimientoPorInversionProjection {

    Long getIdMovimiento();

    String getCategoria();

    String getConcepto();

    BigDecimal getCantidad();

    String getMedida();

    BigDecimal getBalance();

    String getMoneda();

    LocalDateTime getFechaUltimaActividad();
}
