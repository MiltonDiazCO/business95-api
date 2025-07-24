package com.business95.api.business95_api.exceptions;

public class MovimientoNoEncontradoException extends RuntimeException {

    public MovimientoNoEncontradoException(Long id) {
        super("El movimiento con ID " + id + " no se encuentra registrado en el sistema.");
    }

}
