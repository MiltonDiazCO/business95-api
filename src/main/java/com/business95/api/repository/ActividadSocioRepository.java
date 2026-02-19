package com.business95.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.dto.response.ActividadRecienteResponse;
import com.business95.api.entity.ActividadSocio;

@Repository
public interface ActividadSocioRepository extends CrudRepository<ActividadSocio, Long> {

    @Query("""
            SELECT new com.business95.api.dto.response.ActividadRecienteResponse(
                act_soc.idActividad, soc.idSocio AS idSocio,
                TRIM(CONCAT(soc.nombresRazonsocial, ' ', soc.apellidos)) AS socio,
                act_soc.cantidad AS cantidad, act_soc.monto AS monto,
                act_soc.fecha AS fecha, act_soc.tipoActividad.tipoActividad AS tipoActividad,
                mov.idMovimiento AS idMovimiento, mov.concepto AS movimiento,
                inv.idInversion AS idInversion, inv.inversion AS inversion
            ) FROM ActividadSocio act_soc
            JOIN act_soc.socio soc
            JOIN act_soc.movimiento mov
            JOIN mov.inversion inv
            JOIN inv.socios inv_soc
            WHERE inv_soc.socio.idSocio = :idSocio
            ORDER BY act_soc.fecha DESC
                """)
    List<ActividadRecienteResponse> actividadesRecientes(@Param("idSocio") Long idSocio);

}
