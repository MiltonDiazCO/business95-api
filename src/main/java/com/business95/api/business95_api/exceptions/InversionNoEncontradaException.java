package com.business95.api.business95_api.exceptions;

public class InversionNoEncontradaException extends RuntimeException {

    public InversionNoEncontradaException(Long id) {
        super("La inversión con ID " + id + ", no existe");
    }

}
