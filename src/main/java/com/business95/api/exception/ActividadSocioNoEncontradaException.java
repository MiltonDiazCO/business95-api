package com.business95.api.exception;

public class ActividadSocioNoEncontradaException extends RuntimeException {

    public ActividadSocioNoEncontradaException(Long id) {
        super("La actividad con ID " + id + " no se encuentra registrada en el sistema.");
    }

}
