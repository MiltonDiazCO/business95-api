package com.business95.api.business95_api.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MovimientoExceptionHandler {
    public static final String errorRegistroMovimiento = "Error al registrar el movimiento. Por favor, corrija los siguientes errores.";

    @ExceptionHandler(MovimientoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> movimientoNoEncontradoException(MovimientoNoEncontradoException exc,
            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(errorRegistroMovimiento);
        errorResponse.setErrores(Arrays.asList(exc.getMessage()));
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
