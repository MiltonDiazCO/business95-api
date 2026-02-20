package com.business95.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.dto.response.BalanceMovimientoResponse;
import com.business95.api.dto.response.BalanceSocioPorMovimientoResponse;
import com.business95.api.dto.response.MovimientoRecienteResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.entity.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

        List<Movimiento> findByInversionIdInversion(Long idInversion);

        // @formatter:off
        @Query("""
                SELECT new com.business95.api.dto.response.BalanceMovimientoResponse(
                        m.idMovimiento AS idMovimiento, m.inversion.inversion AS inversion,
                        m.concepto AS concepto, m.categoria.categoria AS categoria,
                        SUM(a.cantidad) AS cantidadMovimiento, md.medida AS medida,
                        SUM(a.monto) AS balanceMovimiento, m.moneda.idMoneda AS moneda
                ) FROM Movimiento m
                LEFT JOIN m.actividadesSocio a
                LEFT JOIN m.medida md
                WHERE m.idMovimiento = :idMovimiento
                GROUP BY m.idMovimiento
                """)
        Optional<BalanceMovimientoResponse> balanceMovimiento(
                @Param("idMovimiento") Long idMovimiento);
        // @formatter:on

        // @formatter:off
        @Query("""
                SELECT new com.business95.api.dto.response.BalanceSocioPorMovimientoResponse(
                        a.socio.idSocio AS idSocio,
                        TRIM(CONCAT(a.socio.nombresRazonsocial, ' ',
                                COALESCE(a.socio.apellidos, ''))) AS socio,
                        SUM(a.cantidad) AS cantidadSocio, SUM(a.monto) AS balanceSocio
                ) FROM Movimiento m
                LEFT JOIN m.actividadesSocio a
                WHERE m.idMovimiento = :idMovimiento
                GROUP BY a.socio.idSocio
                """)
        List<BalanceSocioPorMovimientoResponse> balanceSocioPorMovimiento(
                        @Param("idMovimiento") Long idMovimiento);
        // @formatter:on

        // @formatter:off
        @Query("""
                SELECT new com.business95.api.dto.response.ResumenMovimientoResponse(
                        m.idMovimiento AS idMovimiento, m.concepto AS concepto,
                        m.categoria.categoria AS categoria,
                        SUM(a.cantidad) AS cantidad, md.medida AS medida,
                        SUM(a.monto) AS balance, m.moneda.idMoneda AS moneda,
                        MIN(a.fecha) AS fechaApertura,
                        MAX(a.fecha) AS fechaUltimaActividad
                ) FROM Movimiento m
                LEFT JOIN m.actividadesSocio a
                LEFT JOIN m.medida md
                WHERE m.inversion.idInversion = :idInversion
                GROUP BY m.idMovimiento
                """)
        Page<ResumenMovimientoResponse> resumenMovimientosPorInversion(
                        @Param("idInversion") Long idInversion,
                        Pageable pageable);
        // @formatter:on

        // @formatter:off
        @Query("""
                SELECT new com.business95.api.dto.response.MovimientoRecienteResponse(
                        m.idMovimiento AS idMovimiento, inv.idInversion AS idInversion,
                        inv.inversion AS inversion, m.concepto AS concepto,
                        m.categoria.categoria AS categoria,
                        SUM(a.cantidad) AS cantidad, md.medida AS medida,
                        SUM(a.monto) AS balance, m.moneda.idMoneda AS moneda,
                        MIN(a.fecha) AS fechaApertura,
                        MAX(a.fecha) AS fechaUltimaActividad
                ) FROM Movimiento m
                LEFT JOIN m.actividadesSocio a
                LEFT JOIN m.medida md
                JOIN m.inversion inv
                JOIN inv.socios soc
                WHERE soc.socio.idSocio = :idSocio
                GROUP BY m.idMovimiento
                ORDER BY MAX(a.fecha) DESC
                """)
        Page<MovimientoRecienteResponse> movimientosRecientes(
                        @Param("idSocio") Long idSocio,
                        Pageable pageable);
        // @formatter:on

}