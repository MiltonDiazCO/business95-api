package com.business95.api.business95_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.responses.ActividadSocioResponse;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.projections.BalanceSocioPorMovimientoProjection;
import com.business95.api.business95_api.projections.MovimientoPorInversionProjection;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

        @Query("SELECT new com.business95.api.business95_api.dtos.responses.ActividadSocioResponse(" +
                        "a.idActividad AS idActividad, " +
                        "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos) AS socio, " +
                        "a.cantidad AS cantidad, a.monto AS monto, a.fecha AS fecha, " +
                        "a.tipoActividad.tipoActividad AS tipoActividad) FROM Movimiento m " +
                        "LEFT JOIN m.moneda mo LEFT JOIN m.medida md LEFT JOIN m.actividadesSocio a " +
                        "WHERE m.idMovimiento = :idMovimiento ORDER BY a.fecha DESC")
        List<ActividadSocioResponse> actividadesPorMovimiento(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT m.idMovimiento AS idMovimiento, " + "m.inversion.inversion AS inversion, " +
                        "m.concepto AS concepto, " + "m.categoria.categoria AS categoria, " +
                        "md.medida AS medida, " + "mo.moneda AS moneda, " +
                        "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos) AS socio, " +
                        "SUM(a.cantidad) AS cantidad, " + "SUM(a.monto) AS balanceMonetario " +
                        "FROM Movimiento m " + "LEFT JOIN m.medida md " + "LEFT JOIN m.moneda mo " +
                        "LEFT JOIN m.actividadesSocio a " + "WHERE m.idMovimiento = :idMovimiento " +
                        "GROUP BY m.idMovimiento, a.socio.idSocio")
        List<BalanceSocioPorMovimientoProjection> balanceSocioPorMovimiento(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT m.idMovimiento AS idMovimiento, m.categoria.categoria AS categoria, " +
                        "m.concepto AS concepto, SUM(a.cantidad) AS cantidad, " +
                        "md.medida AS medida, SUM(a.monto) AS balance, " +
                        "m.moneda.idMoneda AS moneda, MAX(a.fecha) AS fechaUltimaActividad " +
                        "FROM Movimiento m LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida md " +
                        "WHERE m.inversion.idInversion = :idInversion GROUP BY m.idMovimiento ")
        List<MovimientoPorInversionProjection> movimientoPorInversion(@Param("idInversion") Long idMovimiento);

}