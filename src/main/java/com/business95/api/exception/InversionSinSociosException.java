package com.business95.api.exception;

public class InversionSinSociosException extends RuntimeException {

    public InversionSinSociosException() {
        super("La inversión no puede quedar sin socios asociados.");
    }

    

}
