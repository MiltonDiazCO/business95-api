package com.business95.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.entity.Medida;
import com.business95.api.service.interfaces.MedidaService;

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
