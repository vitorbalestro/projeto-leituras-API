package com.vitorbalestro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitorbalestro.model.Categoria;
import com.vitorbalestro.service.CategoriaService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path="categorias") 
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("{idCategoria}") 
    public Categoria recuperarCategoriaPorId(@PathVariable("idCategoria") Long id) {
        return categoriaService.recuperarCategoriaPorId(id);
    }

}
