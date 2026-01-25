package com.business95.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.entity.TipoPersona;
import com.business95.api.service.interfaces.TipoPersonaService;

@RestController
@RequestMapping("/tipo-personas")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaService tipoPersonaService;

    @GetMapping
    public List<TipoPersona> tipoPersonas() {
        return tipoPersonaService.obtenerTodos();
    }

}
