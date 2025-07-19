package com.business95.api.business95_api.exceptions;

public class CategoriaNoEncontradaException extends RuntimeException {

    public CategoriaNoEncontradaException(Long id) {
        super("La categoría con ID " + id + " no se encuentra registrada en el sistema.");
    }

}
