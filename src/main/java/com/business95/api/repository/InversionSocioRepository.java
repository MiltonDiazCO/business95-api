package com.business95.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.dto.response.SocioPorInversionResponse;
import com.business95.api.entity.InversionSocio;

@Repository
public interface InversionSocioRepository extends CrudRepository<InversionSocio, Long> {

        // @formatter:off
        @Query("""
                SELECT new com.business95.api.dto.response.SocioPorInversionResponse(
                    s.id AS idSocio,
                    TRIM(CONCAT(s.nombresRazonsocial, ' ', s.apellidos)) AS socio,
                    r.rol AS rol,
                    i.fechaRegistro AS fechaRegistro,
                    i.fechaModificacion AS fechaModificacion,
                    sc.id AS idSocioCreacion,
                    TRIM(CONCAT(sc.nombresRazonsocial, ' ', sc.apellidos)) AS socioCreacion,
                    sm.id AS idSocioModificacion,
                    TRIM(CONCAT(sm.nombresRazonsocial, ' ', sm.apellidos)) AS socioModificacion
                ) FROM InversionSocio i
                JOIN i.socio s
                JOIN i.rol r
                JOIN i.socioCreacion sc
                JOIN i.socioModificacion sm
                WHERE i.inversion.id = :idInversion
                """)
        Page<SocioPorInversionResponse> buscarByinversionIdInversion(
                        @Param("idInversion") Long idInversion, Pageable pageable);
        // @formatter:on

        // @formatter:off
        @Query("""
                FROM InversionSocio inv_soc
                WHERE inv_soc.inversion.idInversion = :idInversion
                    AND inv_soc.socio.idSocio = :idSocio
                """)
        // @formatter:on
        Optional<InversionSocio> buscarPorInversionYSocio(
                        @Param("idInversion") Long idInversion,
                        @Param("idSocio") Long idSocio);

}
