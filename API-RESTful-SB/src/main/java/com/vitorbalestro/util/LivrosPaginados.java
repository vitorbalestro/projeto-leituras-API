package com.vitorbalestro.util;

import java.util.List;

import com.vitorbalestro.model.Livro;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LivrosPaginados {
	private long totalDeLivros;
	private int totalDePaginas;
	private int paginaCorrente;
	private List<Livro> livros;
	
	public LivrosPaginados(long totalDeLivros, int totalDePaginas, int paginaCorrente, List<Livro> livros) {
		this.totalDeLivros = totalDeLivros;
		this.totalDePaginas = totalDePaginas;
		this.paginaCorrente = paginaCorrente;
		this.livros = livros;
	}
	
	public LivrosPaginados () {
		
	}

	public long getTotalDeLivros() {
		return totalDeLivros;
	}

	public void setTotalDeLivros(long totalDeLivros) {
		this.totalDeLivros = totalDeLivros;
	}

	public int getTotalDePaginas() {
		return totalDePaginas;
	}

	public void setTotalDePaginas(int totalDePaginas) {
		this.totalDePaginas = totalDePaginas;
	}

	public int getPaginaCorrente() {
		return paginaCorrente;
	}

	public void setPaginaCorrente(int paginaCorrente) {
		this.paginaCorrente = paginaCorrente;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
