package com.business95.api.business95_api.exceptions.handlers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class MensajeErrorHttpService {

    @Autowired
    private MessageSource messageSource;

    public String obtenerMensajePorMetodoHttp(String metodo) {
        switch (metodo) {
            case "GET":
                return messageSource.getMessage("error.consulta", null, Locale.getDefault());
            case "POST":
                return messageSource.getMessage("error.registro", null, Locale.getDefault());
            case "PUT":
                return messageSource.getMessage("error.actualizacion", null, Locale.getDefault());
            case "DELETE":
                return messageSource.getMessage("error.eliminacion", null, Locale.getDefault());
            default:
                return messageSource.getMessage("error.operacion.invalida", null, Locale.getDefault());
        }
    }

}
