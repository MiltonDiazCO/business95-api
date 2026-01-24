package com.business95.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.entity.Socio;
import com.business95.api.projection.BalanceAnualSocioProjection;
import com.business95.api.projection.BalanceSocioProjection;

@Repository
public interface SocioRepository extends CrudRepository<Socio, Long> {

        // @formatter:off
        @Query(value = """
                SELECT s.id_socio AS idSocio,
                        TRIM(CONCAT_WS(' ', s.nombres_razonsocial, s.apellidos)) AS socio,
                        SUM(CASE WHEN sub_query.total_socio_por_movimiento > 0
                                THEN sub_query.total_socio_por_movimiento ELSE 0 END) AS ingresos,
                        SUM(CASE WHEN sub_query.total_socio_por_movimiento < 0
                                THEN sub_query.total_socio_por_movimiento ELSE 0 END) AS gastos,
                        COALESCE(SUM(sub_query.total_socio_por_movimiento), 0) AS balance
                FROM socios s
                JOIN (
                        SELECT
                                soc.id_socio AS id_socio, act_soc.id_movimiento AS id_movimiento,
                                SUM(act_soc.monto) AS total_socio_por_movimiento
                        FROM socios soc
                        LEFT JOIN actividades_socios act_soc
                                ON act_soc.id_socio = soc.id_socio
                        GROUP BY soc.id_socio, act_soc.id_movimiento
                ) sub_query ON s.id_socio = sub_query.id_socio
                WHERE s.id_socio = :idSocio
                GROUP BY s.id_socio
                """, nativeQuery = true)
        Optional<BalanceSocioProjection> balanceSocio(@Param("idSocio") Long idSocio);
        // @formatter:on

        // @formatter:off
        @Query(value = """
                SELECT sub_query.annio as annio,
                        SUM(CASE WHEN sub_query.total_movimiento_anual > 0
                                THEN sub_query.total_movimiento_anual ELSE 0 END) AS ingresos,
                        SUM(CASE WHEN sub_query.total_movimiento_anual < 0
                                THEN sub_query.total_movimiento_anual ELSE 0 END) AS gastos,
                        COALESCE(SUM(sub_query.total_movimiento_anual)) AS balanceAnual
                FROM (
                        SELECT
                                s.id_socio AS id_socio, YEAR(act_soc.fecha) AS annio,
                                SUM(act_soc.monto) AS total_movimiento_anual
                        FROM socios s JOIN actividades_socios act_soc
                                ON s.id_socio = act_soc.id_socio
                        GROUP BY act_soc.id_socio,
                                act_soc.id_movimiento,
                                YEAR(act_soc.fecha)
                ) sub_query WHERE sub_query.id_socio = :idSocio
                GROUP BY sub_query.id_socio, sub_query.annio
                """, nativeQuery = true)
        List<BalanceAnualSocioProjection> balanceAnualSocio(@Param("idSocio") Long idSocio);
        // @formatter:on

}
