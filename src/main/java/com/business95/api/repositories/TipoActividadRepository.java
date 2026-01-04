package com.business95.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business95.api.entities.TipoActividad;

@Repository
public interface TipoActividadRepository extends CrudRepository<TipoActividad, Long> {

}
