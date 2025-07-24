package com.business95.api.business95_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO;
import com.business95.api.business95_api.entities.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

    @Query("SELECT new com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO(" +
            "m.idMovimiento, m.concepto, m.categoria.categoria, mo.moneda," +
            "md.medida, m.inversion.inversion, a.idActividad," +
            "CONCAT(a.socio.nombresRazonsocial, ' ', a.socio.apellidos)," +
            "a.monto, a.cantidad, a.fecha, a.tipoActividad.tipoActividad)" +
            "FROM Movimiento m LEFT JOIN m.moneda mo LEFT JOIN m.medida md " +
            "LEFT JOIN m.actividadesSocio a WHERE m.idMovimiento = :idMovimiento ORDER BY a.fecha")
    List<MovimientoConsultaDTO> findMovimientoDTOById(@Param("idMovimiento") Long idMovimiento);

}