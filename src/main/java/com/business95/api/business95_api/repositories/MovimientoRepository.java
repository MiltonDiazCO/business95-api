package com.business95.api.business95_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.responses.ActividadSocioResponse;
import com.business95.api.business95_api.dtos.responses.BalanceMovimientoResponse;
import com.business95.api.business95_api.dtos.responses.BalanceSocioResponse;
import com.business95.api.business95_api.dtos.responses.MovimientoConBalancesResponse;
import com.business95.api.business95_api.entities.Movimiento;

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

        @Query("SELECT new com.business95.api.business95_api.dtos.responses.BalanceSocioResponse(" +
                        "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos) AS socio, " +
                        "SUM(a.cantidad) AS cantidadSocio, SUM(a.monto) AS balanceSocio) " +
                        "FROM Movimiento m LEFT JOIN m.medida md LEFT JOIN m.moneda mo " +
                        "LEFT JOIN m.actividadesSocio a WHERE m.idMovimiento = :idMovimiento " +
                        "GROUP BY m.idMovimiento, a.socio.idSocio")
        List<BalanceSocioResponse> balanceSociosPorMovimiento(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT new com.business95.api.business95_api.dtos.responses.MovimientoConBalancesResponse(" +
                        "m.idMovimiento AS idMovimiento, m.inversion.inversion AS inversion, " +
                        "m.concepto AS concepto, m.categoria.categoria AS categoria, " +
                        "SUM(a.cantidad) AS cantidadMovimiento, md.medida AS medida, " +
                        "SUM(a.monto) AS balanceMovimiento, m.moneda.idMoneda AS moneda) " +
                        "FROM Movimiento m LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida md " +
                        "WHERE m.idMovimiento = :idMovimiento GROUP BY m.idMovimiento ")
        MovimientoConBalancesResponse balanceMovimiento(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT new com.business95.api.business95_api.dtos.responses.BalanceMovimientoResponse(" +
                        "m.idMovimiento AS idMovimiento, m.concepto AS concepto, " +
                        "m.categoria.categoria AS categoria, " +
                        "SUM(a.cantidad) AS cantidadMovimiento, md.medida AS medida, " +
                        "SUM(a.monto) AS balanceMovimiento, m.moneda.idMoneda AS moneda, " +
                        "MAX(a.fecha) AS fechaUltimaActividad) " +
                        "FROM Movimiento m LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida md " +
                        "WHERE m.inversion.idInversion = :idInversion GROUP BY m.idMovimiento ")
        List<BalanceMovimientoResponse> balanceMovimientosPorInversion(@Param("idInversion") Long idInversion);

}