package com.business95.api.business95_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.dto.MovimientoDTO;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> movimientos() {
        return movimientoService.findAll();
    }

    @PostMapping
    public MovimientoDTO registrarMovimiento(@RequestBody MovimientoDTO movimientoDTO) {
        return movimientoService.save(movimientoDTO);
    }

}
