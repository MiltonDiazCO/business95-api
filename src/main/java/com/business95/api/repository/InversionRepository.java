package com.business95.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.entity.Inversion;
import com.business95.api.projection.BalanceInversionProjection;
import com.business95.api.projection.BalanceSocioPorInversionProjection;

@Repository
public interface InversionRepository extends CrudRepository<Inversion, Long> {

        @Query(value = "SELECT inv.id_inversion as idInversion, inv.inversion AS inversion, " +
                        "SUM(CASE WHEN sub_query.total_movimiento > 0 " +
                        "       THEN sub_query.total_movimiento ELSE 0 END) AS ingresos, " +
                        "SUM(CASE WHEN sub_query.total_movimiento < 0 " +
                        "       THEN sub_query.total_movimiento ELSE 0 END) AS gastos, " +
                        "COALESCE(SUM(sub_query.total_movimiento), 0) AS balance " +
                        "FROM inversiones inv " +
                        "LEFT JOIN (" +
                        "       SELECT inv.id_inversion AS id_inversion, " +
                        "       SUM(act_soc.monto) AS total_movimiento FROM inversiones inv " +
                        "       LEFT JOIN movimientos mov ON inv.id_inversion = mov.id_inversion " +
                        "       INNER JOIN actividades_socios act_soc " +
                        "       ON mov.id_movimiento = act_soc.id_movimiento " +
                        "       GROUP BY act_soc.id_movimiento " +
                        ") sub_query ON inv.id_inversion = sub_query.id_inversion " +
                        "WHERE inv.id_inversion IN " +
                        "(SELECT DISTINCT id_inversion FROM inversiones_socios " +
                        "       WHERE id_socio = :idSocio)" +
                        "OR inv.id_inversion IN " +
                        "(SELECT DISTINCT id_inversion FROM inversiones_socios " +
                        "       WHERE id_inversion = :idInversion)" +
                        "GROUP BY inv.id_inversion", nativeQuery = true)
        List<BalanceInversionProjection> balanceInversionPorIdSocioOIdInversion(
                        @Param("idSocio") Long idSocio,
                        @Param("idInversion") Long idInversion);

        @Query(value = "SELECT s.id_socio AS idSocio, " +
                        "TRIM(CONCAT_WS(' ', s.nombres_razonsocial, s.apellidos)) AS socio, " +
                        "SUM(CASE WHEN sub_query.total_socio_por_movimiento > 0 " +
                        "       THEN sub_query.total_socio_por_movimiento ELSE 0 END) AS ingresos, " +
                        "SUM(CASE WHEN sub_query.total_socio_por_movimiento < 0 " +
                        "       THEN sub_query.total_socio_por_movimiento ELSE 0 END) AS gastos, " +
                        "SUM(sub_query.total_socio_por_movimiento) AS balance " +
                        "FROM inversiones inv " +
                        "LEFT JOIN ( " +
                        "       SELECT inv.id_inversion AS id_inversion, " +
                        "       act_soc.id_socio AS id_socio, " +
                        "       SUM(act_soc.monto) AS total_socio_por_movimiento " +
                        "       FROM inversiones inv LEFT JOIN movimientos mov " +
                        "       ON inv.id_inversion = mov.id_inversion " +
                        "       INNER JOIN actividades_socios act_soc " +
                        "       ON mov.id_movimiento = act_soc.id_movimiento " +
                        "       GROUP BY act_soc.id_socio, act_soc.id_movimiento " +
                        ") sub_query ON inv.id_inversion = sub_query.id_inversion " +
                        "INNER JOIN socios s ON sub_query.id_socio = s.id_socio " +
                        "WHERE inv.id_inversion = :idInversion " +
                        "GROUP BY s.id_socio, inv.id_inversion", nativeQuery = true)
        List<BalanceSocioPorInversionProjection> balanceSociosPorInversion(@Param("idInversion") Long idInversion);

}
