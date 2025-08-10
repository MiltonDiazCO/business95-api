package com.business95.api.business95_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.projections.BalanceSociosPorMovimientoConsultaDTO;
import com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO;
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

        @Query("SELECT new com.business95.api.business95_api.dtos.projections.BalanceSociosPorMovimientoConsultaDTO(" +
                        "m.idMovimiento, m.inversion.inversion, m.concepto, m.categoria.categoria, md.medida," +
                        "mo.moneda, CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos)," +
                        "SUM(a.cantidad), SUM(a.monto)) FROM Movimiento m LEFT JOIN m.medida md " +
                        "LEFT JOIN m.moneda mo LEFT JOIN m.actividadesSocio a " +
                        "WHERE m.idMovimiento = :idMovimiento GROUP BY m.idMovimiento, a.socio.idSocio")
        List<BalanceSociosPorMovimientoConsultaDTO> balanceSociosPorMovimiento(
                        @Param("idMovimiento") Long idMovimiento);

}