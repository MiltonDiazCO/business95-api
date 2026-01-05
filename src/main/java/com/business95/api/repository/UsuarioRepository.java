package com.business95.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business95.api.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}
