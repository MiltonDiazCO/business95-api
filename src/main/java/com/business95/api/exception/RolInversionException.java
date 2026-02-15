package com.business95.api.exception;

public class RolInversionException extends RuntimeException {

    public RolInversionException() {
        super("El rol enviado no es valido para los módulos de administración.");
    }

    

}
