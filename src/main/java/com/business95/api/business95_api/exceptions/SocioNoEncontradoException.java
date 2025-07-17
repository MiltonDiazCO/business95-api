package com.business95.api.business95_api.exceptions;

public class SocioNoEncontradoException extends RuntimeException {

    public SocioNoEncontradoException(Long id) {
        super("El socio con ID " + id + ", no existe");
    }

}
