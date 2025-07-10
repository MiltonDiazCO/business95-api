package com.business95.api.business95_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business95.api.business95_api.entities.TipoPersona;

@Repository
public interface TipoPersonaRepository extends CrudRepository<TipoPersona, Long> {

}
