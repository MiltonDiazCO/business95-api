package com.business95.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.dto.response.ActividadSocioResponse;
import com.business95.api.dto.response.BalanceSocioPorMovimientoResponse;
import com.business95.api.dto.response.MovimientoConBalancesResponse;
import com.business95.api.entity.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

        @Query("SELECT new com.business95.api.dto.response.ActividadSocioResponse(" +
                        "a.idActividad AS idActividad, " +
                        "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos) AS socio, " +
                        "a.cantidad AS cantidad, a.monto AS monto, a.fecha AS fecha, " +
                        "a.tipoActividad.tipoActividad AS tipoActividad) FROM Movimiento m " +
                        "LEFT JOIN m.moneda mo LEFT JOIN m.medida md LEFT JOIN m.actividadesSocio a " +
                        "WHERE m.idMovimiento = :idMovimiento ORDER BY a.fecha DESC")
        List<ActividadSocioResponse> actividadesPorMovimiento(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT new com.business95.api.dto.response.MovimientoConBalancesResponse    (" +
                        "m.idMovimiento AS idMovimiento, m.inversion.inversion AS inversion, " +
                        "m.concepto AS concepto, m.categoria.categoria AS categoria, " +
                        "SUM(a.cantidad) AS cantidadMovimiento, md.medida AS medida, " +
                        "SUM(a.monto) AS balanceMovimiento, m.moneda.idMoneda AS moneda) " +
                        "FROM Movimiento m LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida md " +
                        "WHERE m.idMovimiento = :idMovimiento GROUP BY m.idMovimiento")
        Optional<MovimientoConBalancesResponse> balanceMovimiento(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT new com.business95.api.dto.response.BalanceSocioPorMovimientoResponse(" +
                        "a.socio.idSocio AS idSocio, " +
                        "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos) AS socio, " +
                        "SUM(a.cantidad) AS cantidadSocio, SUM(a.monto) AS balanceSocio) " +
                        "FROM Movimiento m " +
                        "LEFT JOIN m.actividadesSocio a WHERE m.idMovimiento = :idMovimiento " +
                        "GROUP BY m.idMovimiento, a.socio.idSocio")
        List<BalanceSocioPorMovimientoResponse> balanceSocioPorMovimiento(@Param("idMovimiento") Long idMovimiento);

}