package com.business95.api.exception;

public class RolNoEncontradoException extends RuntimeException {

    public RolNoEncontradoException(String rol) {
        super("El rol " + rol + " no se encuentra registrado en el sistema.");
    }

}
