package com.business95.api.business95_api.exceptions.handlers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String errorRegistroMovimiento = "Formato de entrada inválido. Por favor, verifique que los datos enviados tengan el formato correcto.";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> formatoEntradaInvalidoException(HttpMessageNotReadableException exc,
            HttpServletRequest request) {

        String mensajeErrorNumeroIncorrecto = exc.getMessage();

        if (exc.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidExc = (InvalidFormatException) exc.getCause();

            if (invalidExc.getTargetType().equals(BigDecimal.class) || invalidExc.getTargetType().equals(Long.class)) {
                mensajeErrorNumeroIncorrecto = "Se esperaba un número válido (sin letras ni símbolos).";
            }
        }

        if (exc.getCause() instanceof MismatchedInputException) {
            MismatchedInputException mismatchedExc = (MismatchedInputException) exc.getCause();

            if (mismatchedExc.getTargetType().equals(LocalDateTime.class)) {
                mensajeErrorNumeroIncorrecto = "Se esperaba una fecha en formato ISO. Ejemplo: '2025-07-19T14:30:00'";
            }
        }

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(mensajeErrorNumeroIncorrecto));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
