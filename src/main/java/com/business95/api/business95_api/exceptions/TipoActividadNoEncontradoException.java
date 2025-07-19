package com.business95.api.business95_api.exceptions;

public class TipoActividadNoEncontradoException extends RuntimeException {

    public TipoActividadNoEncontradoException(Long id) {
        super("El tipo de actividad con ID " + id + " no se encuentra registrado en el sistema.");
    }

}
