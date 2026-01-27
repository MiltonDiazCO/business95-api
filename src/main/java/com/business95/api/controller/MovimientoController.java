package com.business95.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.dto.request.ActividadSocioRequest;
import com.business95.api.dto.request.MovimientoRequest;
import com.business95.api.dto.request.MovimientoUpdateRequest;
import com.business95.api.dto.response.MovimientoConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoResponse;
import com.business95.api.service.interfaces.ActividadService;
import com.business95.api.service.interfaces.MovimientoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private MovimientoService movimientoService;
    private ActividadService actividadService;

    public MovimientoController(
            MovimientoService movimientoService,
            ActividadService actividadService) {
        this.movimientoService = movimientoService;
        this.actividadService = actividadService;
    }

    @GetMapping("/{idMovimiento}")
    public ResponseEntity<MovimientoResponse> movimientoPorId(@PathVariable Long idMovimiento) {
        return ResponseEntity.ok().body(movimientoService.movimientoPorId(idMovimiento));
    }

    @GetMapping("/{idMovimiento}/balance-socios")
    public ResponseEntity<MovimientoConBalancesSociosResponse> balanceSociosPorMovimiento(
            @PathVariable Long idMovimiento) {
        return ResponseEntity.ok().body(movimientoService.balanceSociosPorMovimiento(idMovimiento));
    }

    @PostMapping
    public ResponseEntity<?> registrarMovimiento(
            @Valid @RequestBody MovimientoRequest movimientoRegistroDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movimientoService.guardar(movimientoRegistroDTO));
    }

    @PutMapping("/{idMovimiento}")
    public ResponseEntity<?> actualizarMovimiento(
            @PathVariable Long idMovimiento,
            @Valid @RequestBody MovimientoUpdateRequest movimientoUpdateRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movimientoService.actualizar(idMovimiento, movimientoUpdateRequest));
    }

    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<Long> elimianrMovimiento(@PathVariable Long idMovimiento) {
        movimientoService.eliminar(idMovimiento);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idMovimiento}/actividades")
    public ResponseEntity<?> registrarActividad(
            @PathVariable Long idMovimiento,
            @Valid @RequestBody List<ActividadSocioRequest> actividadesSociosRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(actividadService.guardar(idMovimiento, actividadesSociosRequest));
    }

    @PutMapping("/{idMovimiento}/actividades")
    public ResponseEntity<?> actualizarActividad(
            @PathVariable Long idMovimiento,
            @Valid @RequestBody List<ActividadSocioRequest> actividadesSociosRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(actividadService.guardar(idMovimiento, actividadesSociosRequest));
    }

    @DeleteMapping("/{idMovimiento}/actividades")
    public ResponseEntity<Long> elimianrActividad(
            @PathVariable Long idMovimiento,
            @RequestBody ArrayList<Long> idActividades) {
        actividadService.eliminar(idMovimiento, idActividades);
        return ResponseEntity.noContent().build();
    }

}
