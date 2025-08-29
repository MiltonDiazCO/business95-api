package com.business95.api.business95_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.projections.BalanceSocioPorMovimientoConsultaDTO;
import com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO;
import com.business95.api.business95_api.dtos.projections.MovimientoPorInversionConsultaDTO;
import com.business95.api.business95_api.entities.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

        @Query("SELECT new com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO(" +
                        "m.idMovimiento, m.inversion.inversion, m.concepto, m.categoria.categoria," +
                        "md.medida, mo.moneda, a.idActividad," +
                        "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos)," +
                        "a.cantidad, a.monto, a.fecha, a.tipoActividad.tipoActividad)" +
                        "FROM Movimiento m LEFT JOIN m.moneda mo LEFT JOIN m.medida md " +
                        "LEFT JOIN m.actividadesSocio a WHERE m.idMovimiento = :idMovimiento ORDER BY a.fecha DESC")
        List<MovimientoConsultaDTO> movimientoPorId(@Param("idMovimiento") Long idMovimiento);

        @Query("SELECT new com.business95.api.business95_api.dtos.projections.BalanceSocioPorMovimientoConsultaDTO(" +
                        "m.idMovimiento, m.inversion.inversion, m.concepto, m.categoria.categoria, md.medida," +
                        "mo.moneda, CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos)," +
                        "SUM(a.cantidad), SUM(a.monto)) FROM Movimiento m LEFT JOIN m.medida md " +
                        "LEFT JOIN m.moneda mo LEFT JOIN m.actividadesSocio a " +
                        "WHERE m.idMovimiento = :idMovimiento GROUP BY m.idMovimiento, a.socio.idSocio")
        List<BalanceSocioPorMovimientoConsultaDTO> balanceSocioPorMovimiento(
                        @Param("idMovimiento") Long idMovimiento);

        @Query("SELECT new com.business95.api.business95_api.dtos.projections.MovimientoPorInversionConsultaDTO(" +
                        "m.idMovimiento, m.categoria.categoria, m.concepto, SUM(a.cantidad), md.medida," +
                        "SUM(a.monto), m.moneda.idMoneda, MAX(a.fecha)) FROM Movimiento m " +
                        "LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida " +
                        "md WHERE m.inversion.idInversion = :idInversion " +
                        "GROUP BY m.idMovimiento ORDER BY MAX(a.fecha) DESC")
        List<MovimientoPorInversionConsultaDTO> findMovimientosPorInversion(@Param("idInversion") Long idInversion);

}