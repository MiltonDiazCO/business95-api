package com.business95.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business95.api.entity.ActividadSocio;

@Repository
public interface ActividadSocioRepository extends CrudRepository<ActividadSocio, Long> {

}
