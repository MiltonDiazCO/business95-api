package com.business95.api.business95_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.entities.Medida;
import com.business95.api.business95_api.servicies.interfaces.MedidaService;

@RestController
@RequestMapping("/medidas")
public class MedidaController {

    @Autowired
    private MedidaService medidaService;

    @GetMapping
    public List<Medida> medidas() {
        return medidaService.findAll();
    }

}
