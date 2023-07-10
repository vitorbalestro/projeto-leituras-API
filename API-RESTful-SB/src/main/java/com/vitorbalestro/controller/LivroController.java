package com.vitorbalestro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitorbalestro.model.Livro;
import com.vitorbalestro.service.LivroService;
import com.vitorbalestro.util.LivrosPaginados;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("livros") 
public class LivroController {
	
	@Autowired
    private LivroService livroService;

	@GetMapping("{idLivro}") 
    public Livro recuperarLivroPorId(@PathVariable("idLivro") Long id) {
        return livroService.recuperarLivroPorId(id);
    }
	
	@PostMapping
	public Livro cadastrarLivro(@RequestBody Livro livro) {
	    return livroService.cadastrarLivro(livro);
	}
	
	@GetMapping
	public List<Livro> recuperarLivros() {
	        return livroService.recuperarLivros();
	}
	
    @PutMapping
    public Livro atualizarProduto(@RequestBody Livro livro) {
        return livroService.atualizarLivro(livro);
    }

    @DeleteMapping("{idLivro}")  
    public void removerLivro(@PathVariable("idLivro") Long id) {
        livroService.removerLivro(id);
    }
    
    @GetMapping("paginacao")
    public LivrosPaginados recuperarLivrosPaginados(
    		@RequestParam(name="pagina", defaultValue="0") int pagina,
    		@RequestParam(name="tamanho", defaultValue="5") int tamanho) {
    	Pageable pageable = PageRequest.of(pagina, tamanho);
    	Page<Livro> paginaDeLivro = livroService.recuperarLivrosPaginados(pageable);
    	LivrosPaginados livrosPaginados = new LivrosPaginados(
    			paginaDeLivro.getTotalElements(),
    			paginaDeLivro.getTotalPages(),
    			paginaDeLivro.getNumber(),
    			paginaDeLivro.getContent());
    	
    	return livrosPaginados;
    }
    
    
}
           

