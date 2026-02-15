package com.business95.api.exception;

public class RolSistemaException extends RuntimeException {

    public RolSistemaException() {
        super("El rol enviado no es valido para los módulos de inversiones.");
    }

}
