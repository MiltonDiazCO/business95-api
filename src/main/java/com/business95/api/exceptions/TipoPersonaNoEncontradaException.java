package com.business95.api.exceptions;

public class TipoPersonaNoEncontradaException extends RuntimeException {

    public TipoPersonaNoEncontradaException(Long id) {
        super("El tipo de persona con ID " + id + " no se encuentra registrado en el sistema.");
    }

}
