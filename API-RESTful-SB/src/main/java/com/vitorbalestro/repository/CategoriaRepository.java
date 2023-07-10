package com.vitorbalestro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorbalestro.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    
}
