package com.business95.api.business95_api.exceptions;

public class ActividadSocioNoEncontradaException extends RuntimeException {

    public ActividadSocioNoEncontradaException(Long id) {
        super("La actividad con ID " + id + " no se encuentra registrada en el sistema.");
    }

}
