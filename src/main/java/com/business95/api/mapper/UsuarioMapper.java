package com.business95.api.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.business95.api.dto.response.UsuarioResponse;
import com.business95.api.entity.Rol;
import com.business95.api.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "roles", target = "roles", qualifiedByName = "getRolesString")
    UsuarioResponse toUsuarioResponse(Usuario usuario);

    @Named("getRolesString")
    default Set<String> getRolesString(Set<Rol> roles) {

        if (roles.isEmpty()) {
            return null;
        }

        return roles.stream().map(Rol::getRol).collect(Collectors.toSet());

    }

}
