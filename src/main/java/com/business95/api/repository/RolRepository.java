package com.business95.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.business95.api.entity.Rol;

public interface RolRepository extends CrudRepository<Rol, Long> {

    Optional<Rol> findByRol(String rol);

}