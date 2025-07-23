package com.business95.api.business95_api.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.dto.projection.MovimientoConsultaDTO;
import com.business95.api.business95_api.dto.request.MovimientoRequestDTO;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.handlers.ErrorResponse;
import com.business95.api.business95_api.exceptions.handlers.MovimientoExceptionHandler;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/{idMovimiento}")
    public List<MovimientoConsultaDTO> movimientoPorId(@PathVariable Long idMovimiento) {
        return movimientoService.findMovimientoDTOById(idMovimiento);
    }

    @PostMapping
    public ResponseEntity<?> registrarMovimiento(@Valid @RequestBody MovimientoRequestDTO movimientoRegistroDTO,
            BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            ErrorResponse errorResponse = new ErrorResponse();

            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });

            errorResponse.setMensaje(MovimientoExceptionHandler.errorRegistroMovimiento);
            errorResponse.setErrores(List.copyOf(errores.values()));
            errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
            errorResponse.setRuta(request.getRequestURI());
            errorResponse.setFecha(LocalDateTime.now());

            return ResponseEntity.badRequest().body(errorResponse);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimientoRegistroDTO));
    }

}
