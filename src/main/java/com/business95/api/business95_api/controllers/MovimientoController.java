package com.business95.api.business95_api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoUpdateRequestDTO;
import com.business95.api.business95_api.dtos.responses.BalanceSociosPorMovimientoResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponseDTO;
import com.business95.api.business95_api.servicies.interfaces.ActividadService;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;
import com.business95.api.business95_api.utils.ErrorUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private ActividadService actividadService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/{idMovimiento}")
    public ResponseEntity<MovimientoResponseDTO> movimientoPorId(@PathVariable Long idMovimiento) {
        return ResponseEntity.ok().body(movimientoService.movimientoPorId(idMovimiento));
    }

    @GetMapping("/{idMovimiento}/actividades/balance")
    public ResponseEntity<BalanceSociosPorMovimientoResponseDTO> balanceSociosPorMovimiento(
            @PathVariable Long idMovimiento) {
        return ResponseEntity.ok().body(movimientoService.balanceSociosPorMovimiento(idMovimiento));
    }

    @PostMapping
    public ResponseEntity<?> registrarMovimiento(@Valid @RequestBody MovimientoRequestDTO movimientoRegistroDTO,
            BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(
                    messageSource.getMessage("error.registro", null, Locale.getDefault()),
                    result, HttpStatus.BAD_REQUEST.value(), request);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimientoRegistroDTO));
    }

    @PutMapping("/{idMovimiento}")
    public ResponseEntity<?> actualizarMovimiento(@PathVariable Long idMovimiento,
            @Valid @RequestBody MovimientoUpdateRequestDTO movimientoUpdateRequestDTO,
            BindingResult result,
            HttpServletRequest request) {

        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(
                    messageSource.getMessage("error.actualizacion", null, Locale.getDefault()),
                    result, HttpStatus.BAD_REQUEST.value(), request);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movimientoService.update(idMovimiento, movimientoUpdateRequestDTO));
    }

    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<Long> elimianrMovimiento(@PathVariable Long idMovimiento) {
        movimientoService.delete(idMovimiento);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idMovimiento}/actividades")
    public ResponseEntity<?> registrarActividad(
            @PathVariable Long idMovimiento,
            @Valid @RequestBody List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs,
            BindingResult result,
            HttpServletRequest request) {

        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(
                    messageSource.getMessage("error.registro", null, Locale.getDefault()),
                    result, HttpStatus.BAD_REQUEST.value(), request);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveActividadSocio(idMovimiento, actividadesSocioRequestDTOs));
    }

    @PutMapping("/{idMovimiento}/actividades")
    public ResponseEntity<?> actualizarActividad(
            @PathVariable Long idMovimiento,
            @Valid @RequestBody List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs,
            BindingResult result,
            HttpServletRequest request) {

        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(
                    messageSource.getMessage("error.actualizacion", null, Locale.getDefault()),
                    result, HttpStatus.BAD_REQUEST.value(), request);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveActividadSocio(idMovimiento, actividadesSocioRequestDTOs));
    }

    @DeleteMapping("/{idMovimiento}/actividades")
    public ResponseEntity<Long> elimianrActividad(@PathVariable Long idMovimiento,
            @RequestBody ArrayList<Long> idActividades) {
        actividadService.delete(idMovimiento, idActividades);
        return ResponseEntity.noContent().build();
    }

    private List<ActividadSocioRequestDTO> saveActividadSocio(Long idMovimiento,
            List<ActividadSocioRequestDTO> actividadesSocioRequestDTOs) {
        return actividadService.save(idMovimiento, actividadesSocioRequestDTOs);
    }

}
