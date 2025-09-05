package com.business95.api.business95_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.entities.Socio;
import com.business95.api.business95_api.projections.BalanceAnualSocioProjection;
import com.business95.api.business95_api.projections.BalanceSocioProjection;

@Repository
public interface SocioRepository extends CrudRepository<Socio, Long> {

    @Query(value = "SELECT CONCAT_WS(' ', s.nombres_razonsocial, s.apellidos) AS socio, " +
            "SUM(CASE WHEN sub_query.totalPorSocioMovimiento > 0 " +
            "THEN sub_query.totalPorSocioMovimiento ELSE 0 END) AS ingresos, " +
            "SUM(CASE WHEN sub_query.totalPorSocioMovimiento < 0 " +
            "THEN sub_query.totalPorSocioMovimiento ELSE 0 END) AS gastos, " +
            "SUM(sub_query.totalPorSocioMovimiento) AS balanceSocio " +
            "FROM socios s " +
            "JOIN (SELECT sub_soc.id_socio AS idSocio, " +
            "sub_as.id_movimiento AS idMovimiento, " +
            "SUM(sub_as.monto) AS totalPorSocioMovimiento " +
            "FROM socios sub_soc " +
            "JOIN actividades_socios sub_as ON sub_soc.id_socio = sub_as.id_socio " +
            "GROUP BY sub_as.id_socio , sub_as.id_movimiento) sub_query " +
            "ON s.id_socio = sub_query.idSocio " +
            "WHERE s.id_socio = :idSocio " +
            "GROUP BY s.id_socio", nativeQuery = true)
    Optional<BalanceSocioProjection> balanceSocio(@Param("idSocio") Long idSocio);

    @Query(value = "SELECT resumen.annio as annio, " +
            "SUM(CASE WHEN resumen.totalMovimientoAnual > 0 " +
            "THEN resumen.totalMovimientoAnual ELSE 0 END) AS ingresos, " +
            "SUM(CASE WHEN resumen.totalMovimientoAnual < 0 " +
            "THEN resumen.totalMovimientoAnual ELSE 0 END) AS gastos, " +
            "SUM(resumen.totalMovimientoAnual) AS balanceAnual " +
            "FROM socios soc " +
            "JOIN (SELECT s.id_socio AS idSocio, " +
            "YEAR(act_soc.fecha) AS annio, " +
            "SUM(act_soc.monto) AS totalMovimientoAnual " +
            "FROM socios s JOIN actividades_socios act_soc ON s.id_socio = act_soc.id_socio " +
            "GROUP BY act_soc.id_socio, act_soc.id_movimiento, YEAR(act_soc.fecha)) " +
            "resumen ON soc.id_socio = resumen.idSocio " +
            "WHERE soc.id_socio = :idSocio GROUP BY soc.id_socio, resumen.annio", nativeQuery = true)
    List<BalanceAnualSocioProjection> balanceAnualSocio(@Param("idSocio") Long idSocio);

}
