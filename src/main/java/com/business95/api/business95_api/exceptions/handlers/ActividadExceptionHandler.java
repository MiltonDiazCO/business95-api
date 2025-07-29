package com.business95.api.business95_api.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.business95.api.business95_api.exceptions.ActividadSocioNoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ActividadExceptionHandler {

    public static final String ERROR_REGISTRO_ACTIVIDAD = "Error al registrar o actualizar la actividad. Por favor, corrija los siguientes errores.";

    @ExceptionHandler(ActividadSocioNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> actividadSocioNoEncontradaException(ActividadSocioNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(ERROR_REGISTRO_ACTIVIDAD);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.NOT_FOUND.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
