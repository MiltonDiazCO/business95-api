package com.business95.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business95.api.entity.Categoria;
import com.business95.api.repository.CategoriaRepository;
import com.business95.api.service.interfaces.CategoriaService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> obtenerTodos() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

}
