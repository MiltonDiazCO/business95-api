package com.business95.api.business95_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.entities.Moneda;
import com.business95.api.business95_api.servicies.interfaces.MonedaService;

@RestController
@RequestMapping("monedas")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @GetMapping
    public List<Moneda> monedas() {
        return monedaService.findAll();
    }

}
