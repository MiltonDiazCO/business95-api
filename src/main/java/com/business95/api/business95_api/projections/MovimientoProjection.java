package com.business95.api.business95_api.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface MovimientoProjection {

    Long getIdMovimiento();

    String getInversion();

    String getConcepto();

    String getCategoria();

    String getMedida();

    String getMoneda();

    Long getIdActividad();

    String getSocio();

    BigDecimal getCantidad();

    BigDecimal getMonto();

    LocalDateTime getFecha();

    String getTipoActividad();
}
