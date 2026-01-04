package com.business95.api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business95.api.entities.Categoria;
import com.business95.api.repositories.CategoriaRepository;
import com.business95.api.servicies.interfaces.CategoriaService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

}
