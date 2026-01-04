package com.business95.api.exceptions;

public class InversionNoEncontradaException extends RuntimeException {

    public InversionNoEncontradaException(Long id) {
        super("La inversión con ID " + id + " no se encuentra registrada en el sistema.");
    }

}
