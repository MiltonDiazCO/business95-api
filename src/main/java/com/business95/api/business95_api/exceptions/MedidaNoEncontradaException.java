package com.business95.api.business95_api.exceptions;

public class MedidaNoEncontradaException extends RuntimeException {

    public MedidaNoEncontradaException(Long id) {
        super("La medida con ID " + id + ", no existe");
    }

}
