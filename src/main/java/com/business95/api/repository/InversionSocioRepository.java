package com.business95.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.entity.InversionSocio;

@Repository
public interface InversionSocioRepository extends CrudRepository<InversionSocio, Long> {

    @Query("""
                FROM InversionSocio inv_soc
                WHERE inv_soc.inversion.idInversion = :idInversion
                    AND inv_soc.socio.idSocio = :idSocio
            """)
    Optional<InversionSocio> buscarPorInversionYSocio(
            @Param("idInversion") Long idInversion,
            @Param("idSocio") Long idSocio);

}
