package com.vitorbalestro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorbalestro.exception.EntidadeNaoEncontradaException;
import com.vitorbalestro.model.Categoria;
import com.vitorbalestro.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria recuperarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Categoria número " + id + " não encontrada."));
    }

}
