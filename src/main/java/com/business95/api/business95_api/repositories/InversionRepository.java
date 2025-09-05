package com.business95.api.business95_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.responses.BalanceMovsPorInvRes;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.projections.BalanceInversionProjection;
import com.business95.api.business95_api.projections.BalanceSocioPorInvProjection;

@Repository
public interface InversionRepository extends CrudRepository<Inversion, Long> {

        @Query("SELECT new com.business95.api.business95_api.dtos.responses.BalanceMovsPorInvRes(" +
                        "m.idMovimiento AS idMovimiento, m.concepto AS concepto, " +
                        "m.categoria.categoria AS categoria, " +
                        "SUM(a.cantidad) AS cantidadMovimiento, md.medida AS medida, " +
                        "SUM(a.monto) AS balanceMovimiento, m.moneda.idMoneda AS moneda, " +
                        "MAX(a.fecha) AS fechaUltimaActividad) " +
                        "FROM Movimiento m LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida md " +
                        "WHERE m.inversion.idInversion = :idInversion GROUP BY m.idMovimiento")
        Optional<List<BalanceMovsPorInvRes>> balanceMovimientosPorInversion(@Param("idInversion") Long idInversion);

        @Query(value = "SELECT inv.inversion AS inversion, " +
                        "SUM(CASE WHEN resumen.total_inversion > 0 " +
                        "THEN resumen.total_inversion ELSE 0 END) AS ingresos, " +
                        "SUM(CASE WHEN resumen.total_inversion < 0 " +
                        "THEN resumen.total_inversion ELSE 0 END) AS gastos, " +
                        "SUM(resumen.total_inversion) AS balanceInversion FROM inversiones inv " +
                        "LEFT JOIN (SELECT inv.id_inversion AS id_inversion, " +
                        "SUM(act_soc.monto) AS total_inversion FROM inversiones inv " +
                        "JOIN movimientos mov ON inv.id_inversion = mov.id_inversion " +
                        "LEFT JOIN actividades_socios act_soc " +
                        "ON mov.id_movimiento = act_soc.id_movimiento " +
                        "GROUP BY act_soc.id_movimiento) " +
                        "resumen ON inv.id_inversion = resumen.id_inversion " +
                        "WHERE inv.id_inversion = :idInversion " +
                        "GROUP BY resumen.id_inversion", nativeQuery = true)
        Optional<BalanceInversionProjection> balanceInversion(@Param("idInversion") Long idInversion);

        @Query(value = "SELECT CONCAT_WS(' ', s.nombres_razonsocial, s.apellidos) AS socio, " +
                        "SUM(CASE WHEN resumen.total_socio > 0 " +
                        "THEN resumen.total_socio ELSE 0 END) AS ingresos, " +
                        "SUM(CASE WHEN resumen.total_socio < 0 " +
                        "THEN resumen.total_socio ELSE 0 END) AS gastos, " +
                        "SUM(resumen.total_socio) AS balanceSocio FROM inversiones inv " +
                        "LEFT JOIN (SELECT inv.id_inversion AS id_inversion, " +
                        "act_soc.id_socio AS id_socio, SUM(act_soc.monto) AS total_socio " +
                        "FROM inversiones inv JOIN movimientos mov ON inv.id_inversion = mov.id_inversion " +
                        "LEFT JOIN actividades_socios act_soc ON mov.id_movimiento = act_soc.id_movimiento " +
                        "GROUP BY act_soc.id_socio, act_soc.id_movimiento) " +
                        "resumen ON inv.id_inversion = resumen.id_inversion " +
                        "JOIN socios s ON resumen.id_socio = s.id_socio " +
                        "WHERE inv.id_inversion = :idInversion " +
                        "GROUP BY resumen.id_socio, resumen.id_inversion", nativeQuery = true)
        List<BalanceSocioPorInvProjection> balanceSocioPorInversion(@Param("idInversion") Long idInversion);

}
