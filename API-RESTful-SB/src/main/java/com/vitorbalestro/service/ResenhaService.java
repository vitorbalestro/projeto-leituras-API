package com.vitorbalestro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorbalestro.exception.EntidadeNaoEncontradaException;
import com.vitorbalestro.model.Resenha;
import com.vitorbalestro.repository.ResenhaRepository;

@Service
public class ResenhaService {
	 @Autowired
	 private ResenhaRepository resenhaRepository;
	 
	 public List<Resenha> recuperarResenhas() {
	        return resenhaRepository.findAll();
	 }
	 
	 public Resenha cadastrarResenha(Resenha resenha) {
	     return resenhaRepository.save(resenha);
	 }
	 
	 public Resenha recuperarResenhaPorId(Long id) {
	        return resenhaRepository.findById(id)
	                .orElseThrow(() -> new EntidadeNaoEncontradaException(
	                        "Resenha número " + id + " não encontrada."));
	 }
	 
	 public List<Resenha> recuperarResenhasPorLivro(Long id) {
	        return resenhaRepository.findByLivroId(id);
	 }
	 
	 @Transactional
	 public void removerResenha(Long id) {
	        recuperarResenhaPorId(id);
	        resenhaRepository.deleteResenhaPorId(id);
	 }
	 
	 
	 public Resenha atualizarResenha(Resenha resenha) {
	        
	        Resenha umaResenha = recuperarResenhaPorId(resenha.getId());
	        if (!(resenha.getLivro().getId().equals(umaResenha.getLivro().getId()))) {
	            resenhaRepository.findById(resenha.getLivro().getId())
	                    .orElseThrow(()-> new EntidadeNaoEncontradaException(
	                            "Categoria número " + resenha.getLivro().getId() + " não encontrada."));
	        }
	        return resenhaRepository.save(resenha);
	    }
	 
}
