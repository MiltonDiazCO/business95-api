package com.business95.api.business95_api.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ActividadRequeridaException.class)
    public ResponseEntity<ErrorResponse> actividadRequeridaException(ActividadRequeridaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(exc.getMessage());
        errorResponse.setCodigoEstado(HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.unprocessableEntity().body(errorResponse);
    }

    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> categoriaNoEncontradaException(CategoriaNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(exc.getMessage());
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MonedaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> monedaNoEncontradaException(MonedaNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(exc.getMessage());
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MedidaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> medidaNoEncontradaException(MedidaNoEncontradaException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(exc.getMessage());
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
