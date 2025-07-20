package com.business95.api.business95_api.exceptions.handlers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MovimientoExceptionHandler {

    public static final String errorRegistroMovimiento = "Error al registrar el movimiento. Por favor, corrija los siguientes errores.";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> formatoEntradaInvalidoException(HttpMessageNotReadableException exc,
            HttpServletRequest request) {

        String mensajeErrorNumeroIncorrecto = exc.getMessage();

        if (exc.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidExc = (InvalidFormatException) exc.getCause();

            if (invalidExc.getTargetType().equals(BigDecimal.class)) {
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

    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> categoriaNoEncontradaException(CategoriaNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MonedaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> monedaNoEncontradaException(MonedaNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MedidaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> medidaNoEncontradaException(MedidaNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(InversionNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> inversionNoEncontradaException(InversionNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(SocioNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> socioNoEncontradoException(SocioNoEncontradoException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(TipoActividadNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> tipoActividadNoEncontradoException(TipoActividadNoEncontradoException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
