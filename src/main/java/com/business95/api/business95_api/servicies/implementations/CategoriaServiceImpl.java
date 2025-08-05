package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business95.api.business95_api.entities.Categoria;
import com.business95.api.business95_api.repositories.CategoriaRepository;
import com.business95.api.business95_api.servicies.interfaces.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

}
