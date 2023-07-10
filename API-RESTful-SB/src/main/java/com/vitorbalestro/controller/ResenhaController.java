package com.vitorbalestro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitorbalestro.model.Resenha;
import com.vitorbalestro.service.ResenhaService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path ="resenhas") 
public class ResenhaController {
	
	@Autowired
    private ResenhaService resenhaService;
	
	@PostMapping
	public Resenha cadastrarResenha(@RequestBody Resenha resenha) {
	    return resenhaService.cadastrarResenha(resenha);
	}
	
	@GetMapping
	public List<Resenha> recuperarResenhas() {
	        return resenhaService.recuperarResenhas();
	}
	
	@GetMapping("{idResenha}") 
    public Resenha recuperarResenhaPorId(@PathVariable("idResenha") Long id) {
        return resenhaService.recuperarResenhaPorId(id);
    }
	
	@GetMapping("livro/{idLivro}")
	public List<Resenha> recuperarResenhasPorLivroV1(@PathVariable("idLivro") Long id) {
	    return resenhaService.recuperarResenhasPorLivro(id);
	}

	@DeleteMapping("/{idResenha}")    
    public void removerResenha(@PathVariable("idResenha") Long id) {
        resenhaService.removerResenha(id);
    }
	
	@PutMapping
    public Resenha atualizarResenha(@RequestBody Resenha resenha) {
        return resenhaService.atualizarResenha(resenha);
    }
}
