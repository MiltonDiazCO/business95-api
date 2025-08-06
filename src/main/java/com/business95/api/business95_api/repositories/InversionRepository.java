package com.business95.api.business95_api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.projections.MovimientoPorInversionConsultaDTO;
import com.business95.api.business95_api.entities.Inversion;

@Repository
public interface InversionRepository extends CrudRepository<Inversion, Long> {

    @Query("SELECT new com.business95.api.business95_api.dtos.projections.MovimientoPorInversionConsultaDTO(" +
            "m.idMovimiento, m.categoria.categoria, m.concepto, SUM(a.cantidad), md.medida," +
            "SUM(a.monto), m.moneda.idMoneda, MAX(a.fecha)) FROM Movimiento m " +
            "LEFT JOIN m.actividadesSocio a LEFT JOIN m.medida md WHERE m.inversion.idInversion = :idInversion " +
            "GROUP BY m.idMovimiento ORDER BY MAX(a.fecha) DESC")
    Iterable<MovimientoPorInversionConsultaDTO> findMovimientosPorInversion(@Param("idInversion") Long idInversion);

}
