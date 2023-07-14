package com.vitorbalestro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorbalestro.exception.EntidadeNaoEncontradaException;
import com.vitorbalestro.model.Livro;
import com.vitorbalestro.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
   
    public List<Livro> recuperarLivros() {
        return livroRepository.findAll();
    }

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
    
    public Livro recuperarLivroPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Livro número " + id + " não encontrado."));
    }
    
    public void removerLivro(Long id) {
        recuperarLivroPorId(id);
        livroRepository.deleteById(id);
    }

    @Transactional
    public void removerLivroV2(Long id) {
        recuperarLivroPorId(id);
        livroRepository.deleteByIdV2(id);
    }
        
    public Livro atualizarLivro(Livro livro) {        
        return livroRepository.save(livro);
    }
    
    public Page<Livro> recuperarLivrosPaginados(Pageable pageable){
    	return livroRepository.recuperarLivrosPaginados(pageable);
    }

    public List<Livro> recuperarLivrosPorCategoria(Long id) {
	    return livroRepository.findByCategoriaId(id);
	}
    
}
