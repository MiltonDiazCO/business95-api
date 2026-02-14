package com.business95.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business95.api.entity.Permiso;

@Repository
public interface PermisoRepository extends CrudRepository<Permiso, Long> {

    @Query("FROM Permiso p JOIN p.roles r WHERE r.rol = :rol AND p.permiso = :permiso")
    Optional<Permiso> buscarPorRolYPermiso(@Param("rol") String rol, @Param("permiso") String permiso);

}
